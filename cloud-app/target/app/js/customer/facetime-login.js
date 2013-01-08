   $(function(){
	   
	   var usernameEle = $("input[name=username]");
	   var emailEle = $("input[name=email]");
	   var passwordEle = $("input[name=password]");
	   var registerBtn = $("input[name=register]");
	   var useHttps = $("input[name=useHttps]");
	   var clientId;
	   
	   if(util.getCookie('email')){
		   usernameEle.val(util.getCookie('email'));
	   }else if(util.getCookie('email')){
		   usernameEle.val(util.getCookie('username'));
	   }
	   
	   $("#login").bind("click",function(){
		   var loginDTO = getLoginDTO();
		   var p = location.protocol +"//"+location.host+"/app/pub/login";
			
		   sendAjax(p, JSON.stringify(loginDTO), function(data) {
			   switch (data) {
				case "OK":
					goSystem();
					break;
				case 'ERR_USERNAME_IS_EMPTY': 
					showMsg(i18n.prop('messages.err_username_is_empty'));
					break;
				case 'ERR_USER_NOT_EXIST':
					showMsg(i18n.prop('messages.err_user_not_exist'));
					break;
				case 'ERR_PWD_NOT_MATCH':
					showMsg(i18n.prop('messages.err_pwd_not_match'));
					break;
				case 'ERR_SYS_ERR':
				default:
					showMsg(i18n.prop('messages.err_sys_err'));
					break; 
				}
			});
		   // end bind submit
	   });
	   
	   $("#register").bind("click",function(){
		   
		   var loginDTO = getLoginDTO();
		   var p = location.protocol +"//"+location.host+"/app/pub/register";
		   
		   sendAjax(p, JSON.stringify(loginDTO), function(data) {
			   switch (data) {
				case "OK":
					showMsg("注册成功! <span>5秒后自动进入系统!</span>");
					var count = 4 ;
					window.setInterval( function(){
						if(count == 0){
							window.clearInterval();
							goSystem();
						}else{
							$("#message > span").html(count+"秒后自动进入系统!");
							count--;
						}
					},1000);
					break;
				case 'ERR_USERNAME_IS_EMPTY': 
					showMsg(i18n.prop('messages.err_username_is_empty'));
					break;
				case 'ERR_USERNAME_EXIST':
					showMsg(i18n.prop('messages.err_username_exist'));
					break;
				case 'ERR_EMAIL_EXIST':
					showMsg(i18n.prop('messages.err_email_exist'));
					break;
				case 'ERR_SYS_ERR':
				default:
					showMsg(i18n.prop('messages.err_sys_err'));
					break; 
				}
			});
		   // end bind submit
	   });
	   
	   function getLoginDTO(){
		   var username = usernameEle.val();
		   var email = emailEle.val();
		   var password = passwordEle.val();
		   clientId = util.guid();
		   
		   $.cookie("username",username);
		   $.cookie("email",email);
		   
		   setInputEnable(false);
		   
		   var loginDTO = {
					username : username,
					password : password,
					email : email,
					clientId : clientId
				};
		   
		   securityLoginDTO(loginDTO);
		   return loginDTO;
	   }
	   
	   function sendAjax(ajaxUri, data, onresponse){
			$.ajax({
				url : ajaxUri,
				type : 'POST',
				data : {'data':data},
				dataType : 'html',
				success : onresponse,
				fail : function() {
					setMsg(i18n.prop("messages.err_sys_err"));
				},
				complete : function() {
					setInputEnable(true);
				}
			});
	   }
	   
	   function goSystem() {
			var url = (useHttps.is(':checked') ? 'https:'
					: location.protocol)
					+ '//' + location.host;
			url += "/app/file/list";
			url += util.setUrlEncodedKey('clientId', clientId,
					location.search);
			location.assign(url);
		}
	   
	   function securityLoginDTO(dto) {
			dto.nonce = Security.randomCharString();
			dto.password = Crypto.SHA256(dto.password);
			dto.hashKey = Crypto.SHA256(dto.username + dto.password+ dto.nonce);

			dto.password = Security.codeDecode(dto.nonce, Security.byteStringToHexString(dto.password));
			return dto;
		}
	   
	   function setInputEnable(enable) {
			usernameEle.attr("disabled", !enable);
			passwordEle.attr("disabled", !enable);
			emailEle.attr("disabled", !enable);
			registerBtn.attr("disabled", !enable);
		}

	   
	   function showMsg(msg) {
		   $("#message").html(msg);
		}
	   
	   // end jquery
   });