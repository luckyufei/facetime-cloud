$(document)
		.ready(
				function() {
					var userName, password, loginButton, useHttps, clientId, message;

					userName = $('#userName');
					password = $('#password');
					
					loginButton = $('#login');
					useHttps = $('#useHttps');
					message = $('#message');
					clientId = util.guid();

					// set cookie value
					function setCookieValue(target, key) {
						var cVal = $.cookie(key);
						if (!!cVal) {
							target.val(cVal);
						}
					}
					
					setCookieValue(userName, 'ua');
					setCookieValue(useHttps, 'uh');

					focus([userName, password ]);

					function focus(inputs) {
						var i, input;
						for (i in inputs) {
							input = inputs[i];
							if (input.val() === '') {
								input.focus();
								return;
							}
						}
						inputs[inputs.length - 1].focus();
					}

					// bind
					loginButton.on('click', function(event) {
						event.preventDefault();
						onLogin();
					});

					function onLogin() {
						setInputEnable(false);
						// setup dto
						var loginDTO = {
							account : userName.val(),
							password : password.val(),
							agent : util.getAgent(),
							clientId : clientId
						};

						saveFieldInCookie(loginDTO);
						securityLoginDTO(loginDTO);
						// showMsg('');

						var p = location.pathname;
						p = p.substring(0, p.lastIndexOf('/')) + '/ajax/flex.do';

						$.ajax({
							url : p,
							type : 'POST',
							headers : {
								serviceType : '/pub/ent/enterpriseUserLogin'
							},
							data : JSON.stringify(loginDTO),
							dataType : 'html',
							success : onServerResponse,
							fail : function() {
								setMsg(i18n.prop('MainConstants.systemError'));
							},
							complete : function() {
								setInputEnable(true);
							}
						});
					}

					function saveFieldInCookie(dto) {
						$.cookie('ua', dto.account);
					}

					function onServerResponse(data) {
						try {
							var clientToken = new ClientToken(data);
							$.cookie('ut', data);
							$.cookie('si', true);

							goSystem();
						} catch (e) {
							switch (data) {
							case 'errorWrongPWD':
							case 'errorWrongAccount':
								showMsg(i18n
										.prop('AuthorizeMessages.failLoginUserOrPassordWrong'));
								break;
							case 'errorUserLocked':
								showMsg(i18n.prop('AuthorizeMessages.userLocked'));
								break;
							default:
								showMsg(i18n.prop('MainConstants.systemError'));
								break;
							}
						}
					}
					function setInputEnable(enable) {
						userName.attr("disabled", !enable);
						password.attr("disabled", !enable);
						loginButton.attr("disabled", !enable);
					}

					function showMsg(msg) {
						message.html(msg);
					}

					function goSystem() {
						var url = (useHttps.is(':checked') ? 'https:'
								: location.protocol)
								+ '//' + location.host;

						var p = location.pathname;
						p = p.substring(0, p.lastIndexOf('/'))
								+ '/enterprise.jsp';

						url += p;
						url += util.setUrlEncodedKey('clientId', clientId,
								location.search);

						location.assign(url);
					}

					function securityLoginDTO(dto) {
						dto.nonce = Security.randomCharString();
						dto.password = Crypto.SHA256(dto.password);
						dto.hashKey = Crypto.SHA256(dto.account + dto.password
								+ dto.nonce);

						dto.password = Security.codeDecode(dto.nonce, Security
								.byteStringToHexString(dto.password));
						return dto;
					}
				});