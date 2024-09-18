var result;
var leftArray = [];
var rightArray = [];
var sideMenuArray = [];
var alerts = [];
var footer = [];
var role;
let validation = /[a-z0-9-\.]+\.[a-z]{2,4}\/?([^\s<>\#%"\,\{\}\\|\\\^\[\]`]+)?$/;
window.onload = function() {
	role=document.getElementById("user-role").value;
	console.log("role",role);
	if(role=="Drisya_HR"){

		window.location.href="/retirement"

	}else if(role=="Drisya_Marketing_Team"){

		document.getElementById("retirement_data").style.opacity=0.5;
		document.getElementById("retirement_data").style.pointerEvents="none";

	}

	// //console.log("hi inside window onload");
	getApi("./api/reference", function(response) {
		result = JSON.parse(response);

		leftArray = result.referencesWithADLogin.data;
		rightArray = result.references.data;
		sideMenuArray = result.referencesSideMenu.data;
		//console.log("e", result);
		populateReferenceWithAD(leftArray);
		populateRightReference(rightArray);
		populateSideMenuReference(sideMenuArray);

	});
}

function getApi(url, callback) {
	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;
	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === 4) {
			callback(this.responseText);
		}
	});
	xhr.open("GET", url);
	xhr.send();
}

function populateRightReference(r) {

	var rightMenu = document.getElementById("rightMenu");
	rightMenu.innerHTML = "";
	for (let i = (r.length - 1); i >= 0; i--) {
		// for (let i =0;i<=(r.length);i++) {
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '              <input type="text" class="input-ctrl"   id="right_text-" value="'
				+ r[i].text
				+ '">\n'
				+ '              </div>\n'
				+ '              <div class="input-row">\n'
				+ '              <input type="text" class="input-ctrl" id="right_url-" value="'
				+ r[i].url
				+ '">\n'
				+ '              </div>\n'
				+ '              <span class="list-ctrl">\n'
				+ '              <button class="delete-list" id="delete_value-" ></button>\n'
				+ '              <button class="edit-list" id="edit_side_menu-" ></button>\n'
				+ '              <button class="save-list"></button>\n'
				+ '              </span>\n';

		rightMenu.appendChild(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});

	}

}
function add_Menu(id) {

	if ($('.input-row .validate-text').length > 0) {
		$('.validate-text').remove();
	}

	var text_span = document.createElement("span");
	text_span.className = "validate-text";

	var url_span = document.createElement("span");
	url_span.className = "validate-text";

	switch (id) {
	case "sideMenuAdd":

		let sidetitle = document.getElementById("side_title").value;
		let sideurl = document.getElementById("side_url").value;

		if (sidetitle.length == 0 || sideurl.length == 0) {

			let errorDiv = document.getElementById("sideMenu_title");
			let errorUrl = document.getElementById("sideMenu_url");

			if (sideurl.length == 0 && sidetitle.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorDiv.append(text_span);
				url_span.innerHTML = "Url not be blank";
				errorUrl.append(url_span);
			} else if (sidetitle.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorDiv.append(text_span);
			} else if (sideurl.length == 0) {
				url_span.innerHTML = "Url is not be blank";
				errorUrl.append(url_span);
			}

			document.getElementById("side_title").value = '';
			document.getElementById("side_url").value = '';

		} else {
			var sideUl = document.getElementById("sideMenu");
			var sideLi = document.createElement("li");
			sideLi.className = "drag-list";
			sideLi.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="side_text-" value="'
					+ sidetitle
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="side_url-" value="'
					+ sideurl
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list" id="edit_side_menu"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			sideUl.prepend(sideLi);

		}

		document.getElementById("side_title").value = '';
		document.getElementById("side_url").value = '';
		break;

	case "addMenuRight":

		let refTitle = document.getElementById("right_title").value;
		let refUrl = document.getElementById("right_url").value;

		if (refTitle.length == 0 || refUrl.length == 0) {

			let errorDiv = document.getElementById("titleRight");
			let errorUrl = document.getElementById("urlRight");

			if (refUrl.length == 0 && refTitle.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorDiv.append(text_span);
				url_span.innerHTML = "Url not be blank";
				errorUrl.append(url_span);
			} else if (refTitle.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorDiv.append(text_span);
			} else if (refUrl.length == 0) {
				url_span.innerHTML = "Url is not be blank";
				errorUrl.append(url_span);
			}

			document.getElementById("side_title").value = '';
			document.getElementById("side_url").value = '';

		} else {
			var rightUl = document.getElementById("rightMenu");
			var rightLi = document.createElement("li");
			rightLi.className = "drag-list";
			rightLi.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="side_text-" value="'
					+ refTitle
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="side_url-" value="'
					+ refUrl
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list" id="edit_side_menu"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			rightUl.prepend(rightLi);

		}
		document.getElementById("side_title").value = '';
		document.getElementById("side_url").value = '';
		break;

	case "addMenuLeft":

		let left_Title = document.getElementById("left_title").value;
		let left_Url = document.getElementById("left_url").value;

		if (left_Url == "" || left_Title == "") {

			let errorDiv = document.getElementById("leftTitle");
			let errorUrl = document.getElementById("leftUrl");
			if (left_Url.length == 0 && left_Title.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorDiv.append(text_span);
				url_span.innerHTML = "Url not be blank";
				errorUrl.append(url_span);
			} else if (left_Title.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorDiv.append(text_span);
			} else if (left_Url.length == 0) {
				url_span.innerHTML = "Url is not be blank";
				errorUrl.append(url_span);
			}

			document.getElementById("left_title").value = '';
			document.getElementById("left_url").value = '';

		} else {
			var leftUl = document.getElementById("left_menu");
			var leftLi = document.createElement("li");
			leftLi.className = "drag-list";
			leftLi.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="side_text-" value="'
					+ left_Title
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="side_url-" value="'
					+ left_Url
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list" id="edit_side_menu"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			leftUl.prepend(leftLi);

		}

		document.getElementById("left_title").value = '';
		document.getElementById("left_url").value = '';
		break;

	}

	$('.delete-list').click(function(e) {
		e.preventDefault();
		$(this).parent().parent('.drag-list').remove();
	});
}

function populateReferenceWithAD(o) {

	var referencePopulateAD = document.getElementById("left_menu");
	referencePopulateAD.innerHTML = "";
	for (let i = (o.length - 1); i >= 0; i--) {
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl"   id="left_text-" value="'
				+ o[i].text
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl" id="left_url-" value="'
				+ o[i].url
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <span class="list-ctrl">\n'
				+ '                                          <button class="delete-list" id="delete_value-"></button>\n'
				+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
				+ '                                          <button class="save-list"></button>\n'
				+ '                                      </span>\n';

		referencePopulateAD.appendChild(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});

	}
}
function signOut(){

    var signout=document.getElementById("signout");
    if(signout.style.display=="none"){
        signout.style.display="flex";
    }
    else{

        signout.style.display="none";
    }
}
function populateSideMenuReference(h) {

	var sideMenu = document.getElementById("sideMenu");
	sideMenu.innerHTML = "";
	for (let i = (h.length - 1); i >= 0; i--) {
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl"   id="side_text-'
				+ i
				+ '"  value="'
				+ h[i].text
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl" id="side_url-'
				+ i
				+ '" value="'
				+ h[i].url
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <span class="list-ctrl">\n'
				+ '                                          <button class="delete-list" id="delete_value-"'
				+ i
				+ ' ></button>\n'
				+ '                                          <button class="edit-list" id="edit_side_menu-"'
				+ i
				+ ' ></button>\n'
				+ '                                          <button class="save-list"></button>\n'
				+ '                                      </span>\n';

		sideMenu.appendChild(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});

	}
}

$(document).ready(function() {
	$('.input-ctrl').keyup(function() {
		$(this).siblings('.validate-text').remove();
	});
});

const publishReference = document.getElementById("publishReference");

publishReference.addEventListener('click', function(event) {
	$('.page-container').addClass('loading');
	publishReference.classList.add('loading');
	var referenceSideMenuData = [];
	var referenceWithAD = [];
	var referenceWithoutAD = [];
	let referencesSideMenu = {};
	let referencesWithADLogin = {};
	let references = {};

	// inputs from sidemenu
	const sideMenuData = document.querySelector('#sideMenu');
	const referenceSideValues = sideMenuData.querySelectorAll('.input-ctrl');

	for (let i = 0; i < (referenceSideValues.length) - 1; i++) {

		if (i % 2 == 0) {

			const text = referenceSideValues[i];
			const url = referenceSideValues[i + 1];

			const text_value = text.value;
			const url_value = url.value;

			let obj = {
				"text" : text_value,
				"url" : url_value
			};

			referenceSideMenuData.unshift(obj);

		}

	}

	referencesSideMenu = {
		"data" : referenceSideMenuData
	}

	//inputs from reference with AD
	const referencewithADData = document.querySelector('#left_menu');
	const referencewithADvalues = referencewithADData
			.querySelectorAll('.input-ctrl')

	for (let i = 0; i < (referencewithADvalues.length) - 1; i++) {

		if (i % 2 == 0) {

			const text = referencewithADvalues[i];
			const url = referencewithADvalues[i + 1];

			const text_value = text.value;
			const url_value = url.value;

			let refWithAD_obj = {
				"text" : text_value,
				"url" : url_value
			};

			referenceWithAD.unshift(refWithAD_obj);

		}

	}

	referencesWithADLogin = {
		"data" : referenceWithAD
	}

	//inputs from reference without AD
	const referencewithoutAData = document.querySelector('#rightMenu');
	const referencewithoutADvalues = referencewithoutAData
			.querySelectorAll('.input-ctrl');

	for (let i = 0; i < (referencewithoutADvalues.length) - 1; i++) {

		if (i % 2 == 0) {

			const text = referencewithoutADvalues[i];
			const url = referencewithoutADvalues[i + 1];

			const text_value = text.value;
			const url_value = url.value;

			let refWithoutAD_obj = {
				"text" : text_value,
				"url" : url_value
			};

			referenceWithoutAD.unshift(refWithoutAD_obj);
			//console.log("result",referenceWithoutAD);
		}

	}

	references = {
		"data" : referenceWithoutAD
	}

	var post_data = JSON.stringify({
		"referencesSideMenu" : referencesSideMenu,
		"referencesWithADLogin" : referencesWithADLogin,
		"references" : references
	});

	//console.log("reference data",post_data);

	postApi("./api/publishReferences", post_data, function(response, status) {
		// alert("Reference page published successfully");
		const tostRow = document.querySelector('#publish-success');
		if (status == 200) {
			let tostContent = document.createElement('p');
			tostContent.innerHTML = "Reference page published Successfully";
			tostRow.classList.add('open');
			tostRow.classList.add('success');
			tostRow.append(tostContent);
		} else {
			let tostContent = document.createElement('p');
			tostContent.innerHTML = "Reference page published Failed";
			tostRow.classList.add('open');
			tostRow.classList.add('failed');
			tostRow.append(tostContent);
		}
		setTimeout(function() {
			publishReference.classList.remove('loading');
			$('.tost-top').toggleClass('open');
			$('.tost-top').find('p').remove();
			$('.page-container').removeClass('loading');
			window.location.reload();
		}, 10000);
	});
});

function postApi(url, reqBody, callback) {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			callback(this.responseText, this.status);
		}
	}

	xhr.open('POST', url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(reqBody);
}