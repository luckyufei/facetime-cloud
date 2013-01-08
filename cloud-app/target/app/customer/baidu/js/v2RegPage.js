(function() {
	var c = function(f, e) {
		if (e.tagName == "INPUT") {
		}
	};
	var a = -1;
	var b = false;
	var d = function(h, f) {
		var l = baidu.dom.query(".pass_reg_des", h)[0];
		if (l.innerHTML != "") {
			var g = [ '<div class="pass_reg_tip_header"></div>',
					'<div class="pass_reg_tip_body_container">',
					'<div class="pass_reg_tip_body">',
					'<div class="pass_rep_tip_content">#content#</div>',
					"</div>", "</div>" ].join("");
			if (baidu.dom.hasClass(h, "pass_reg_p_password")) {
				var e = baidu.dom.query(".pass_reg_err_password", h)[0];
				var k = "strength_weak";
				var m = "弱";
				var i = "weak_word";
				if (a == 1) {
					k = "strength_middle";
					m = "中";
					i = "middle_word"
				} else {
					if (a == 2) {
						k = "strength_weak";
						m = "弱";
						i = "weak_word"
					} else {
						if (a == -1) {
							k = "strength_inner";
							m = "";
							i = "strength_value"
						} else {
							k = "strength_strong";
							m = "强";
							i = "strong_word"
						}
					}
				}
				var j = [
						'<div id="pwd_strength" class="pwd_strength clearfix">',
						'<div class="strength_title">强度：</div>',
						'<div class="strength_value ' + i
								+ '" id="strength_word">' + m + "</div>",
						'<div class="strength_bg">',
						'<div id="pwd_strength_pic" class="strength_inner ' + k
								+ '"></div>',
						"</div>",
						"</div>",
						'<div id="pwd_desorerr" style="display:block;width:250px">'
								+ l.innerHTML + "</div>" ].join("");
				f.innerHTML = g.replace("#content#", j);
				baidu.dom
						.addClass(baidu.g("pwd_strength").parentNode, "hidden");
				baidu.each(baidu.q("pass_reg_err",
						baidu.g("pwd_strength").parentNode), function(n) {
					baidu.dom.setStyles(n, {
						paddingLeft : "75px",
						display : "none",
						width : "100%"
					})
				})
			} else {
				f.innerHTML = g.replace("#content#", l.innerHTML)
			}
			return true
		} else {
			return false
		}
	};
	bdPass.api.reg
			.init({
				outerDomId : "content_reg",
				tpl : _config.tpl,
				u : _config.u,
				noreal_u : _config.noreal_u,
				retu : _config.retu,
				staticpage : _config.staticpage,
				formSimpleElementsArray : _config.formSimpleElementsArray,
				bindEnterSubmit : true,
				onReady : function(f) {
					var t = baidu.dom.query(".pass_reg_p");
					baidu.array.each(t, function(j) {
						if (!baidu.dom.hasClass(j, "pass_reg_p_img_verifycode")
								&& !baidu.dom.hasClass(j,
										"pass_reg_p_verifycode")) {
							baidu.dom.addClass(j, "grid-96")
						}
					});
					baidu.dom.insertHTML(document.body, "beforeEnd",
							"<div class='pass_reg_tips'></div>");
					var m = baidu.dom.query(".pass_reg_tips")[0];
					baidu.dom.insertHTML(document.body, "beforeEnd",
							"<div class='pass_vcode_errs'></div>");
					var i = baidu.dom.query(".pass_reg_suggestusernameul")[0];
					if (i != null) {
						baidu.dom
								.insertHTML(i, "afterBegin",
										'<li class="pass_reg_suggestusernameli_title">从下面选择一个</li>')
					}
					var e = baidu.dom.query(".pass_reg_des");
					baidu.array.each(e, function(j) {
						j.style.display = "none"
					});
					var s = baidu.dom.query(".pass_reg_label");
					baidu.array.each(s, function(j) {
						j.innerHTML = j.innerHTML.replace("：", "")
					});
					var k = baidu.dom.query(".pass_reg_input_email");
					baidu.array.each(k, function(j) {
						if (baidu.browser.ie == null) {
							baidu.dom.setAttr(j, "type", "text")
						}
					});
					var r = baidu.dom.query(".pass_reg_input");
					baidu.array.each(r, function(j) {
						baidu.event.on(j, "mouseover", function() {
							if (!baidu.dom.hasClass(this,
									"pass_reg_input_hover")) {
								baidu.dom
										.addClass(this, "pass_reg_input_hover")
							}
						});
						baidu.event.on(j, "mouseout", function() {
							if (baidu.dom
									.hasClass(this, "pass_reg_input_hover")) {
								baidu.dom.removeClass(this,
										"pass_reg_input_hover")
							}
						})
					});
					var l = baidu.dom.query(".pass_reg_submit")[0];
					baidu.event
							.on(
									l,
									"mouseover",
									function() {
										this.className = "pass_reg_submit pass_reg_submit_hover"
									});
					baidu.event
							.on(
									l,
									"mouseout",
									function() {
										this.className = "pass_reg_submit pass_reg_submit_default"
									});
					baidu.event
							.on(
									l,
									"mousedown",
									function() {
										this.className = "pass_reg_submit pass_reg_submit_mousedown"
									});
					baidu.event
							.on(
									l,
									"mouseup",
									function() {
										this.className = "pass_reg_submit pass_reg_submit_default"
									});
					var x = null;
					baidu.array
							.each(
									r,
									function(j) {
										baidu.event
												.on(
														j,
														"focus",
														function() {
															var A = baidu.dom
																	.getParent(this);
															x = A;
															var C = baidu.dom
																	.getPosition(A);
															var B = baidu.dom
																	.query(".pass_reg_form")[0];
															var y = baidu.dom
																	.getPosition(B);
															m.style.top = (C.top)
																	+ "px";
															m.style.left = (y.left + 420)
																	+ "px";
															if (d(A, m)) {
																m.style.display = "block"
															} else {
																m.style.display = "none"
															}
															if (!baidu.dom
																	.hasClass(
																			this,
																			"pass_reg_input_focus")) {
																baidu.dom
																		.addClass(
																				this,
																				"pass_reg_input_focus")
															}
															if (baidu.dom
																	.hasClass(
																			this,
																			"pass_reg_input_error")) {
																baidu.dom
																		.removeClass(
																				this,
																				"pass_reg_input_error");
																var z = baidu.dom
																		.query(
																				".pass_reg_err",
																				A)[0];
																z.style.display = "none"
															}
														});
										baidu.event
												.on(
														j,
														"blur",
														function() {
															var y = baidu.dom
																	.getParent(this);
															m.style.display = "none";
															if (baidu.dom
																	.hasClass(
																			this,
																			"pass_reg_input_focus")) {
																baidu.dom
																		.removeClass(
																				this,
																				"pass_reg_input_focus")
															}
															if (baidu.dom
																	.hasClass(
																			y,
																			"pass_reg_p_password")) {
																if (a == 2) {
																	baidu
																			.g("pass_reg_password_0_err").style.display = "block";
																	if (!baidu.dom
																			.hasClass(
																					this,
																					"pass_reg_input_error")) {
																		baidu.dom
																				.addClass(
																						this,
																						"pass_reg_input_error")
																	}
																}
															}
														})
									});
					if (baidu.g("pass_reg_suggestusernameul_0") != null) {
						var h = baidu.g("pass_reg_suggestusernameul_0").style.display;
						setInterval(
								function() {
									if (baidu.g("pass_reg_suggestusernameul_0").style.display != h) {
										if (x != null) {
											h = baidu
													.g("pass_reg_suggestusernameul_0").style.display;
											var C = baidu.dom.getPosition(x);
											var z = baidu.dom
													.query(".pass_reg_form")[0];
											var j = baidu.dom.getPosition(z);
											m.style.top = (C.top) + "px";
											m.style.left = (j.left + 420)
													+ "px"
										}
										var y = baidu.dom
												.query(".pass_vcode_errs")[0];
										if (y != null) {
											var D = baidu.dom
													.getPosition(baidu
															.g("pass_reg_p_verifycode_0"));
											var B = D.top;
											var A = D.left;
											var z = baidu.dom
													.query(".pass_reg_form")[0];
											var j = baidu.dom.getPosition(z);
											y.style.top = (B) + "px";
											y.style.left = (j.left + 428)
													+ "px";
											y.style.position = "absolute";
											y.style.display = "block"
										}
									}
								}, 100)
					}
					var g = baidu.dom.query(".pass_reg_suggestusernameli");
					baidu.array.each(g, function(y) {
						var j = baidu.dom
								.query(".pass_reg_suggestuserradio", y)[0];
						j.style.display = "none";
						baidu.event.on(y, "click", function() {
							var A = baidu.dom.query(
									".pass_reg_suggestuserradio", this)[0];
							var z = baidu.dom.query(
									".pass_reg_suggestuserlabel", this)[0];
							var B = baidu.dom
									.query(".pass_reg_suggestuserlabel");
							baidu.array.each(B, function(C) {
								if (baidu.dom.hasClass(C, "selected")) {
									baidu.dom.removeClass(C, "selected")
								}
							});
							baidu.dom.addClass(z, "selected")
						})
					});
					var n = baidu.dom.query(".pass_reg_p_generalerror")[0];
					baidu.dom
							.insertHTML(
									n,
									"beforeBegin",
									'<p class="pass_reg_p pass_reg_p_license grid-96"><input type="checkbox" id="isagree" name="isagree" style="vertical-align:middle;*height:14px" checked/><span style="padding-left:4px">我已阅读并接受<a href="http://passport.baidu.com/protocal.html" target="_blank">《百度用户协议》</a></span></p>');
					baidu.event.on("isagree", "click", function() {
						var j = baidu.dom.query(".pass_reg_generalerror")[0];
						if (this.checked) {
							j.innerHTML = ""
						} else {
							j.innerHTML = "您还未接受百度用户协议"
						}
					});
					baidu.dom.setAttr(baidu.g("pass_reg_email_0"), "tabindex",
							"1");
					if (baidu.g("pass_reg_username_0") != null) {
						baidu.dom.setAttr(baidu.g("pass_reg_username_0"),
								"tabindex", "2")
					}
					baidu.dom.setAttr(baidu.g("pass_reg_password_0"),
							"tabindex", "3");
					baidu.dom.setAttr(baidu.g("pass_reg_repassword_0"),
							"tabindex", "4");
					baidu.dom.setAttr(baidu.g("pass_reg_verifycode_0"),
							"tabindex", "5");
					baidu.dom.setAttr(baidu.g("isagree"), "tabindex", "6");
					baidu.dom.setAttr(baidu.g("pass_reg_submit_0"), "tabindex",
							"7");
					var o = baidu.g("pass_reg_emailautocomplateul_0"), v = 0, p = 8, w = "pass_reg_emailautocomplateli_0_";
					baidu.event
							.on(
									"pass_reg_email_0",
									"keydown",
									function(A) {
										if (o.style.display == "none") {
											baidu.dom.removeClass(w + v,
													"active");
											baidu.dom.addClass(w + 0, "active");
											v = 0;
											return true
										}
										var y = baidu.event.getKeyCode(A);
										switch (y) {
										case 38:
											baidu.dom.removeClass(w + v,
													"active");
											var C;
											do {
												if (v == 0) {
													v = p
												}
												C = baidu.g(w + (--v))
											} while (C.style.display == "none");
											baidu.dom.addClass(C, "active");
											break;
										case 40:
											baidu.dom.removeClass(w + v,
													"active");
											var z;
											do {
												if (v == p - 1) {
													v = -1
												}
												z = baidu.g(w + (++v))
											} while (z.style.display == "none");
											baidu.dom.addClass(z, "active");
											break;
										case 13:
											var B = baidu.g(w + v);
											if (B.style.display == "none") {
												return true
											} else {
												if (baidu.browser.ie) {
													B.click()
												} else {
													var j = document
															.createEvent("MouseEvents");
													j.initEvent("click", true,
															true);
													B.dispatchEvent(j)
												}
											}
											break;
										default:
											return true
										}
									});
					for ( var u = 0; u < p; u++) {
						baidu.event.on("pass_reg_emailautocomplateli_0_" + u,
								"mouseover", function() {
									baidu.dom.removeClass(w + v, "active");
									var j = this.id;
									v = j.charAt(j.length - 1);
									baidu.dom.addClass(this, "active")
								})
					}
					baidu.array.each(baidu.dom.query(".pass_reg_input"),
							function(y) {
								var j = baidu.g(y.id + "_des");
								baidu.event.on(y, "focus", function() {
									j.style.color = "#666"
								});
								baidu.event.on(y, "blur", function() {
									j.style.color = "#bbb"
								})
							});
					var q = baidu.dom.query(".pass_reg_p", baidu.dom
							.q("pass_reg_form")[0]);
					baidu.array
							.each(
									q,
									function(z, B) {
										var A = baidu.dom.query("input", z)[0];
										if (A) {
											var j = baidu.dom.next(A);
											if (j) {
												if (z.className != "pass_reg_p pass_reg_p_verifycode") {
													var y = '<span class="pass_valid_right" style="display:none"></span>';
													baidu.dom.insertHTML(j,
															"afterEnd", y)
												}
											}
										}
									})
				},
				onInputOk : function(e) {
					if (baidu.dom.hasClass(e, "pass_reg_input_error")) {
						baidu.dom.removeClass(e, "pass_reg_input_error")
					}
					if (e.name == "loginpass") {
						b = false
					}
					var g = baidu.dom.getParent(e), h = T.dom.query(
							".pass_reg_err", g)[0], i = T.dom.query(
							".pass_valid_right", g)[0];
					if (h) {
						baidu.dom.hide(h);
						if (baidu.dom.hasClass(e, "pass_reg_input_verifycode")) {
							var f = baidu.dom.query(".pass_vcode_errs")[0];
							f.style.display = "none"
						}
					}
					if (h
							&& baidu.dom.getAttr(h, "class") != "pass_reg_input pass_reg_input_verifycode") {
					}
				},
				onCheckErr : c,
				onSubmitedErr : c,
				onSubmitStart : function(f) {
					window.__email = document.getElementsByName("email")[0] ? document
							.getElementsByName("email")[0].value
							: "";
					window.__username = document.getElementsByName("username")[0] ? document
							.getElementsByName("username")[0].value
							: "";
					if (baidu.g("isagree").checked) {
						f.submit();
						var e = baidu.dom.query(".pass_reg_generalerror")[0];
						e.innerHTML = ""
					} else {
						var e = baidu.dom.query(".pass_reg_generalerror")[0];
						e.innerHTML = "您还未接受百度用户协议"
					}
				},
				onSuggestionShow : function(e) {
					var f = baidu.dom.query(".pass_reg_suggestusernameli", e);
					baidu.array.each(f, function(h) {
						var g = baidu.dom
								.query(".pass_reg_suggestuserlabel", h)[0];
						if (baidu.dom.hasClass(g, "selected")) {
							baidu.dom.removeClass(g, "selected")
						}
					})
				},
				handlePasswordLevel : function(e, h) {
					var g = baidu.g("pwd_strength_pic"), f = baidu
							.g("strength_word");
					a = h;
					if (h == 1) {
						g.className = "strength_inner strength_middle";
						f.innerHTML = "中";
						f.className = "strength_value middle_word";
						b = false
					} else {
						if (h == 2) {
							g.className = "strength_inner strength_weak";
							f.innerHTML = "弱";
							f.className = "strength_value weak_word";
							b = true
						} else {
							if (h == 0) {
								g.className = "strength_inner strength_strong";
								f.innerHTML = "强";
								f.className = "strength_value strong_word";
								baidu.each(baidu.q("pass_reg_err", baidu
										.g("pwd_strength").parentNode),
										function(i) {
											baidu.hide(i)
										});
								b = false
							} else {
								a = -1
							}
						}
					}
				},
				onInputErr : function(j, k) {
					if (!baidu.dom.hasClass(j, "pass_reg_input_error")) {
						baidu.dom.addClass(j, "pass_reg_input_error")
					}
					if (j.id == "pass_reg_email_0" && k == "110023") {
						baidu.g("pass_reg_email_0_err").innerHTML = '该邮箱已被激活，请直接<a href="/v2/?login">登录</a>'
					}
					if (j.id == "pass_reg_email_0" && k == "110024") {
						var p = baidu.g("pass_reg_email_0").value;
						var n = baidu.g("pass_reg_hidden_tpl_0").value;
						baidu.g("pass_reg_email_0_err").innerHTML = '该邮箱已被注册，但未激活，请到验证邮件中激活或者<a href="/v2/?regnotify&needresend=true&tpl='
								+ n + "&user=" + p + '">重发验证邮件</a>'
					}
					var h = baidu.dom.getParent(j);
					var t = baidu.dom.query(".pass_valid_right", h)[0];
					if (t) {
						baidu.dom.hide(t)
					}
					if (baidu.dom.hasClass(j, "pass_reg_input_password")) {
						b = true;
						baidu.g(j.id + "_err").style.display = "block";
						var e = baidu.g("pwd_strength_pic"), f = baidu
								.g("strength_word");
						if (k == "23" || k == "-2" || k == "20" || k == "-3"
								|| k == "21") {
							a = -1;
							if (e) {
								e.className = "strength_inner";
								f.innerHTML = "";
								f.className = "strength_value"
							}
						} else {
							if (k == "1") {
								a = 1;
								if (e) {
									e.className = "strength_inner strength_middle";
									f.innerHTML = "中";
									f.className = "strength_value middle_word"
								}
								if (baidu.dom.hasClass(j,
										"pass_reg_input_error")) {
									baidu.dom.removeClass(j,
											"pass_reg_input_error")
								}
								baidu.g("pass_reg_password_0_err").innerHTML = ""
							} else {
								a = 2;
								if (e) {
									e.className = "strength_inner strength_weak";
									f.innerHTML = "弱";
									f.className = "strength_value weak_word"
								}
							}
						}
					} else {
						if (baidu.dom.hasClass(j, "pass_reg_input_verifycode")) {
							var o = baidu.dom.query(".pass_reg_des_verifycode")[0];
							var m = baidu.dom.query(".pass_reg_err_verifycode")[0];
							var l = baidu.dom.query(".pass_vcode_errs")[0];
							l.innerHTML = m.innerHTML;
							var r = baidu.dom.getPosition(baidu.dom
									.getParent(o));
							var q = r.top;
							var i = r.left;
							var g = baidu.dom.query(".pass_reg_form")[0];
							var s = baidu.dom.getPosition(g);
							l.style.top = (q) + "px";
							l.style.left = (s.left + 428) + "px";
							l.style.position = "absolute";
							l.style.display = "block";
							o.style.display = "none";
							baidu.g(j.id + "_err").style.display = "none"
						} else {
							baidu.g(j.id + "_err").style.display = "block"
						}
					}
				}
			})
})();