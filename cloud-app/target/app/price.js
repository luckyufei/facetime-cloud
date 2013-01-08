$(function() {
	var diskRatio = 100, userRatio = 50, twoYearRatio = 0.88, threeYearRatio = 0.68, conferenceRatio = 20, officeRatio = 20, mailRatio = 10, defaultUserCount = 10, defaultCapacityCount = 5;
	var diskId = "diskId", userId = "userId", conferenceId = "conferenceId", officeId = "officeId", mailId = "mailId", yearId = "yearId";
	var buyListItems = [ diskId, userId, conferenceId, officeId, mailId ];
	var userEffectItems = [ userId, conferenceId, officeId, mailId ];
	var rowStr = "<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";

	var capacityAdd, capacityTotal, capacityPrice, capacitySave;
	var userAdd, userTotal, userAddPrice, userAddSave;
	var checkConference, conferencePrice, conferenceSave, checkOffice, officePrice, officeSave, checkMail, mailPrice, mailSave;
	var yearAdd, currentYearRatio = 1, price = 0, discount = 0;
	;

	$('#incr-capacity').bind("change", function() {
		var diskCapacity = 5 + parseInt($(this).val());
		$("ul:first li:eq(1) h5:first").html(diskCapacity);
		changeBuyList(diskId);
	});

	// 新增用户
	$("#incr-user").bind("change", function() {
		userAdd = parseInt($(this).val());
		$("ul:eq(1) li:eq(1) h5:first").html(userAdd + defaultUserCount);
		if (userAdd <= 0) {
			$("ul:eq(2) li:eq(0) input:checkbox").removeAttr("checked");
			$("ul:eq(2) li:eq(1) input:checkbox").removeAttr("checked");
			$("ul:eq(2) li:eq(2) input:checkbox").removeAttr("checked");
		}
		var i;
		for (i = 0; i < userEffectItems.length; i++) {
			changeBuyList(userEffectItems[i]);
		}
	});

	// 购买时长
	$("#year-item").bind("change", function() {
		yearAdd = parseInt($(this).val());
		$("ul:eq(3) li:eq(1) h5:first").html(yearAdd);
		var i;
		for (i = 0; i < buyListItems.length; i++) {
			changeBuyList(buyListItems[i]);
		}
	});

	// 云视频会议
	$("ul:eq(2) li:eq(0) input:checkbox").bind("click", function() {
		changeBuyList(conferenceId);
	});
	// 云办公
	$("ul:eq(2) li:eq(1) input:checkbox").bind("click", function() {
		changeBuyList(officeId);
	});
	// 云邮件
	$("ul:eq(2) li:eq(2) input:checkbox").bind("click", function() {
		changeBuyList(mailId);
	});

	(function() {
		var ent = util.getUrlEncodedKey("ent");
		var account = util.getUrlEncodedKey("account");
		$("input[name=ent]").val(ent ? ent : "未知");
		$("input[name=account]").val(account ? account : "未知");

		$("input[name=capacityRatio]").val(diskRatio);
		$("input[name=userRatio]").val(userRatio);
		$("input[name=conferenceRatio]").val(conferenceRatio);
		$("input[name=officeRatio]").val(officeRatio);
		$("input[name=mailRatio]").val(mailRatio);

		$("#incr-capacity, #incr-user, #year-item").change();
		changeBuyList(conferenceId);
		changeBuyList(officeId);
		changeBuyList(mailId);
	})();

	/* 修改购物清单 */
	function changeBuyList(flag) {
		updateGlobalVars();
		if (yearAdd <= 0) {
			removeRow(flag);
			return;
		}

		var cellVals = [];
		switch (flag) {
		case diskId:
			if (capacityAdd <= 0) {
				removeRow(flag);
				return;
			}
			var diskEle = getElement(diskId);
			cellVals = [
					"企业网盘扩容",
					"100元/G/年",
					capacityAdd + " G",
					yearAdd + " 年",
					getPriceStr(diskRatio, capacityAdd),
					"企业网盘容量 " + $("ul:first li:eq(1) h5:first").html()
							+ " G, 使用" + yearAdd + "年", "<a href='#'>删除</a>" ];
			updateRow(diskEle, cellVals);
			break;
		case userId:
			if (userAdd <= 0) {
				removeRow(flag);
				return;
			}
			var userEle = getElement(userId);
			cellVals = [
					"新增用户",
					"50元/人/年",
					userAdd + " 人",
					yearAdd + " 年",
					getPriceStr(userRatio, userAdd),
					"用户总数 " + $("ul:eq(1) li:eq(1) h5:first").html() + " 人, 使用"
							+ yearAdd + "年", "<a href='#'>删除</a>" ];
			updateRow(userEle, cellVals);
			break;
		case conferenceId:
			if (userAdd <= 0) {
				removeRow(flag);
				return;
			}
			addMoreService(flag, conferenceRatio, " 云视频会议 ", checkConference);
			break;
		case officeId:
			if (userAdd <= 0) {
				removeRow(flag);
				return;
			}
			addMoreService(flag, officeRatio, " 企业云办公 ", checkOffice);
			break;
		case mailId:
			if (userAdd <= 0) {
				removeRow(flag);
				return;
			}
			addMoreService(flag, mailRatio, " 云邮件管理 ", checkMail);
			break;
		}
	}

	/* 更新全部的变量 */
	function updateGlobalVars() {
		userAdd = parseInt($("#incr-user").val());
		yearAdd = parseInt($("#year-item").val());
		capacityAdd = parseInt($("#incr-capacity").val());
		if (yearAdd == 2)
			currentYearRatio = twoYearRatio;
		else if (yearAdd == 3)
			currentYearRatio = threeYearRatio;
		else
			currentYearRatio = 1;

		checkConference = "checked" == $("ul:eq(2) li:eq(0) input:checkbox")
				.attr("checked") ? true : false;
		checkOffice = "checked" == $("ul:eq(2) li:eq(1) input:checkbox").attr(
				"checked") ? true : false;
		checkMail = "checked" == $("ul:eq(2) li:eq(2) input:checkbox").attr(
				"checked") ? true : false;
		conferencePrice = 0;
		conferenceSave = 0;
		officePrice = 0;
		officeSave = 0;
		mailPrice = 0;
		mailSave = 0;
		// console.log("checkConference: %d, checkOffice:%d, checkMail:
		// %d",checkConference, checkOffice, checkMail);

		capacityTotal = capacityAdd + defaultCapacityCount;
		capacityPrice = getItemPrice(diskRatio, capacityAdd);
		capacitySave = getItemSave(diskRatio, capacityAdd);

		userTotal = defaultUserCount + userAdd;
		userAddPrice = getItemPrice(userRatio, userAdd);
		userAddSave = getItemSave(userRatio, userAdd);

		if (checkConference) {
			conferencePrice = getItemPrice(conferenceRatio, userAdd);
			conferenceSave = getItemSave(conferenceRatio, userAdd);
		}
		if (checkOffice) {
			officePrice = getItemPrice(officeRatio, userAdd);
			officeSave = getItemSave(officeRatio, userAdd);
		}
		if (checkMail) {
			mailPrice = getItemPrice(mailRatio, userAdd);
			mailSave = getItemSave(mailRatio, userAdd);
		}

		price = capacityPrice + userAddPrice + conferencePrice + officePrice
				+ mailPrice;
		// console.log('price: %d, discont:%d',price,discount);
		discount = capacitySave + userAddSave + conferenceSave + officeSave
				+ mailSave;

		$("input[name=capacityAdd]").val(capacityAdd);
		$("input[name=capacityTotal]").val(capacityTotal);
		$("input[name=capacityPrice]").val(capacityPrice);
		$("input[name=capacitySave]").val(capacitySave);

		$("input[name=userAdd]").val(userAdd);
		$("input[name=userTotal]").val(userTotal);
		$("input[name=userAddPrice]").val(userAddPrice);
		$("input[name=userAddSave]").val(userAddSave);

		$("input[name=checkConference]").val(checkConference);
		$("input[name=conferencePrice]").val(conferencePrice);
		$("input[name=conferenceSave]").val(conferenceSave);
		$("input[name=checkOffice]").val(checkOffice);
		$("input[name=officePrice]").val(officePrice);
		$("input[name=officeSave]").val(officeSave);
		$("input[name=checkMail]").val(checkMail);
		$("input[name=mailPrice]").val(mailPrice);
		$("input[name=mailSave]").val(mailSave);

		$("input[name=yearAdd]").val(yearAdd);
		$("input[name=currentYearRatio]").val(currentYearRatio);
		$("input[name=total_fee]").val(price);
		$("input[name=discount]").val(discount);

		$(".price-items-operate span h6, .buy-list-operate span h6")
				.html(price);
		$(".price-items-operate span strong, .buy-list-operate span strong")
				.html(discount);
	}

	function addMoreService(flag, ratio, itemName, check) {
		if (check) {
			var theEle = getElement(flag);
			var title = flag == mailId ? "10元/人/年" : "20元/人/年";
			cellVals = [
					itemName,
					title,
					userAdd + " 人",
					yearAdd + " 年",
					getPriceStr(ratio, userAdd),
					itemName + $("ul:eq(1) li:eq(1) h5:first").html()
							+ " 人, 使用" + yearAdd + "年", "<a href='#'>删除</a>" ];
			updateRow(theEle, cellVals);
		} else {
			removeRow(flag);
		}
	}

	function getItemPrice(ratio, add) {
		return (ratio * add * yearAdd * currentYearRatio);
	}

	function getItemSave(ratio, add) {
		return (Math.round(ratio * add * yearAdd * (1 - currentYearRatio)));
	}

	function removeRow(rowId) {
		$("tbody #" + rowId).remove();
	}

	function getElement(eleId) {
		var diskEle;
		if ($("tbody tr#" + eleId).size() > 0) {
			diskEle = $("tbody tr#" + eleId);
		} else {
			$("tbody ").append(rowStr);
			diskEle = $("tbody tr:last");
			diskEle.attr("id", eleId);
			diskEle.find("td:last-child").bind(
					"click",
					function() {
						removeRow(eleId);
						switch (eleId) {
						case diskId:
							$('#incr-capacity').val(0).change();
							break;
						case userId:
							$("#incr-user").val(0).change();
							break;
						case conferenceId:
							$("ul:eq(2) li:eq(0) input:checkbox").removeAttr(
									"checked");
							updateGlobalVars();
							break;
						case officeId:
							$("ul:eq(2) li:eq(1) input:checkbox").removeAttr(
									"checked");
							updateGlobalVars();
							break;
						case mailId:
							$("ul:eq(2) li:eq(2) input:checkbox").removeAttr(
									"checked");
							updateGlobalVars();
							break;
						}
					});
		}
		return diskEle;
	}

	function getPriceStr(ratio, add) {
		return (ratio * add * yearAdd * currentYearRatio) + " 元"
				+ "<h9>节省&yen;"
				+ (Math.round(ratio * add * yearAdd * (1 - currentYearRatio)))
				+ "元</h9>";
	}

	function updateRow(diskEle, cellVals) {
		var i = 0;
		for (i = 0; i < cellVals.length; i++) {
			diskEle.find("td:eq(" + i + ")").html(cellVals[i]);
		}
	}
});