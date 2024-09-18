var e;
var support_array = [];
var left_array = [];
var right_array = [];
var alerts;
var footer;
var role;
var validation = /[a-z0-9-\.]+\.[a-z]{2,4}\/?([^\s<>\#%"\,\{\}\\|\\\^\[\]`]+)?$/;

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
	getApi("./api/support", function(response) {
		e = JSON.parse(response);
		//console.log("e",e);
		// support_array=e.supportSideMenu.data;
		// left_array=e.supportWithAD.data;
		// right_array=e.supportWithoutAD.data;
		alerts = e.alerts;
		footer = e.footer;
		fetchsupport(e.supportSideMenu.data)
		fetchLeftSupport(e.supportWithAD.data)
		fetchRightSupport(e.supportWithoutAD.data)

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

function fetchsupport(f) {
	// //console.log("e",f);
	let mainDiv = document.getElementById("support_menu");
	mainDiv.innerHTML = "";
	for (let i = (f.length - 1); i >= 0; i--) {
		let li = document.createElement("li");
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		// li.id = "drag_li" + i;
		li.innerHTML = '<div class="input-row">'
				+ '<input type="text" class="input-ctrl" id="text_side-' + i
				+ '" value="' + f[i].text + '" >' + '</div>'
				+ '<div class="input-row">'
				+ '<input type="text" class="input-ctrl" id="text_url-' + i
				+ '" value="' + f[i].url + '" >' + '</div>'
				+ '<span class="list-ctrl">'
				+ '<button class="delete-list"></button>'
				+ ' <button class="edit-list" ></button>'
				+ ' <button class="save-list"></button>' + '</span>'

		mainDiv.appendChild(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});
	}

}

function addSideMenuSupport(id) {
	if ($('.input-row .validate-text').length > 0) {
		$('.validate-text').remove();
	}

	let text_span = document.createElement("span");
	text_span.className = "validate-text";
	let url_span = document.createElement("span");
	url_span.className = "validate-text";

	switch (id) {

	case "side_add":

		let title = document.getElementById("support_label_add").value;
		let url = document.getElementById("support_url_add").value;

		if (title.length == 0 || url.length == 0) {

			let errorText = document.getElementById("side-text-add");
			let errorUrl = document.getElementById("side-url-add");

			if (url.length == 0 && title.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorText.append(text_span);
				url_span.innerHTML = "Url not be blank";
				errorUrl.append(url_span);
			} else if (title.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorText.append(text_span);
			} else if (url.length == 0) {
				url_span.innerHTML = "Url is not be blank";
				errorUrl.append(url_span);
			}

			document.getElementById("support_label_add").value = '';
			document.getElementById("support_url_add").value = '';

		} else {

			let ul = document.getElementById("support_menu");
			let li = document.createElement("li");
			li.className = "drag-list";
			li.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="text_side-" value="'
					+ title
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="text_url-" value="'
					+ url
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list" id="edit_side_menu"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			ul.prepend(li);
			document.getElementById("support_label_add").value = '';
			document.getElementById("support_url_add").value = '';

		}
		break;

	case "menuWithoutAd":

		let titleWithout = document.getElementById("right_add").value;
		let urlWithout = document.getElementById("right_add_url").value;

		if (titleWithout.length == 0 || urlWithout.length == 0) {

			let errorText = document.getElementById("right-text");
			let errorUrl = document.getElementById("right-url");

			if (urlWithout.length == 0 && titleWithout.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorText.append(text_span);
				url_span.innerHTML = "Url not be blank";
				errorUrl.append(url_span);
			} else if (titleWithout.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorText.append(text_span);
			} else if (urlWithout.length == 0) {
				url_span.innerHTML = "Url is not be blank";
				errorUrl.append(url_span);
			}

			document.getElementById("right_add").value = '';
			document.getElementById("right_add_url").value = '';

		} else {

			let ul = document.getElementById("menu-right-support");
			let li = document.createElement("li");
			li.className = "drag-list";
			li.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="text_side-" value="'
					+ titleWithout
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="text_url-" value="'
					+ urlWithout
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list" id="edit_side_menu"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			ul.prepend(li);

			document.getElementById("right_add").value = '';
			document.getElementById("right_add_url").value = '';

		}
		break;

	case "menuWithAd":

		let titleWith = document.getElementById("left_add").value;
		let urlWith = document.getElementById("left_add_url").value;

		if (titleWith.length == 0 || urlWith.length == 0) {

			let errorText = document.getElementById("left-text");
			let errorUrl = document.getElementById("left-url");

			if (urlWith.length == 0 && titleWith.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorText.append(text_span);
				url_span.innerHTML = "Url not be blank";
				errorUrl.append(url_span);
			} else if (titleWith.length == 0) {
				text_span.innerHTML = "Title not be blank";
				errorText.append(text_span);
			} else if (urlWith.length == 0) {
				url_span.innerHTML = "Url is not be blank";
				errorUrl.append(url_span);
			}

			document.getElementById("left_add").value = '';
			document.getElementById("left_add_url").value = '';
		} else {

			let ul = document.getElementById("menu-left-support");
			let li = document.createElement("li");
			li.className = "drag-list";
			li.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="text_side-" value="'
					+ titleWith
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" id="text_url-" value="'
					+ urlWith
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list" id="edit_side_menu"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			ul.prepend(li);
			document.getElementById("left_add").value = '';
			document.getElementById("left_add_url").value = '';

		}
		break;
	}

	$('.delete-list').click(function(e) {
		e.preventDefault();
		$(this).parent().parent('.drag-list').remove();
	});
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
function fetchLeftSupport(g) {

	let mainDiv = document.getElementById("menu-left-support")
	mainDiv.innerHTML = "";
	for (let i = (g.length - 1); i >= 0; i--) {
		let li = document.createElement("li");
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		// li.id = "drag_li" + i;
		li.innerHTML = '<div class="input-row">'
				+ '<input type="text" class="input-ctrl" id="text_side-' + i
				+ '" value="' + g[i].text + '" >' + '</div>'
				+ '<div class="input-row">'
				+ '<input type="text" class="input-ctrl" id="text_url-' + i
				+ '" value="' + g[i].url + '" >' + '</div>'
				+ '<span class="list-ctrl">'
				+ '<button class="delete-list"></button>'
				+ ' <button class="edit-list" ></button>'
				+ ' <button class="save-list"></button>' + '</span>'

		mainDiv.appendChild(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});
	}

}
//

function fetchRightSupport(h) {
	// //console.log("e",f);
	let mainDiv = document.getElementById("menu-right-support")
	mainDiv.innerHTML = "";
	for (let i = (h.length - 1); i >= 0; i--) {
		let li = document.createElement("li");
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		// li.id = "drag_li" + i;
		li.innerHTML = '<div class="input-row">'
				+ '<input type="text" class="input-ctrl" id="text_side-' + i
				+ '" value="' + h[i].text + '" >' + '</div>'
				+ '<div class="input-row">'
				+ '<input type="text" class="input-ctrl" id="text_url-' + i
				+ '" value="' + h[i].url + '" >' + '</div>'
				+ '<span class="list-ctrl">'
				+ '<button class="delete-list"></button>'
				+ ' <button class="edit-list" ></button>'
				+ ' <button class="save-list"></button>' + '</span>'

		mainDiv.appendChild(li);

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

const supportPublish = document.getElementById("publishSupport");

supportPublish.addEventListener('click', function(event) {
	$('.page-container').addClass('loading');
	supportPublish.classList.add('loading');
	var leftArray = [];
	var rightArray = [];
	var sideArray = [];
	var supportWithAD = {};
	var supportWithoutAD = {};
	var supportSideMenu = {};

	// Get all input elements on the sidemenu
	const leftSidemenu = document.querySelector('#menu-left');
	const withAd = leftSidemenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (withAd.length) - 1; i++) {

		if (i % 2 == 0) {

			const textAd = withAd[i];
			const urlAd = withAd[i + 1];

			const text_Ad = textAd.value;
			const url_Ad = urlAd.value;

			let obj = {
				"text" : text_Ad,
				"url" : url_Ad
			};

			leftArray.unshift(obj);

		}

	}

	supportWithAD = {
		"data" : leftArray
	}

	const rightSidemenu = document.querySelector('#menu-right');
	const withoutAd = rightSidemenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (withoutAd.length) - 1; i++) {

		if (i % 2 == 0) {

			const text = withoutAd[i];
			const url = withoutAd[i + 1];

			const text_value = text.value;
			const url_value = url.value;

			let obj = {
				"text" : text_value,
				"url" : url_value
			};

			rightArray.unshift(obj);

		}

	}

	supportWithoutAD = {
		"data" : rightArray
	}

	const Sidemenu = document.querySelector('#sideSupoort');
	const menuList = Sidemenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (menuList.length) - 1; i++) {

		if (i % 2 == 0) {

			const text = menuList[i];
			const url = menuList[i + 1];

			const text_value = text.value;
			const url_value = url.value;

			let obj = {
				"text" : text_value,
				"url" : url_value
			};

			sideArray.unshift(obj);

		}

	}
	supportSideMenu = {
		"data" : sideArray
	}

	var post_data = JSON.stringify({

		"supportWithAD" : supportWithAD,
		"supportSideMenu" : supportSideMenu,
		"supportWithoutAD" : supportWithoutAD,

	});
	//console.log(post_data);
	postApi("./api/publishSupport", post_data, function(response, status) {
		// alert("success");
		const tostRow = document.querySelector('#publish-success');
		if (status == 200) {
			let tostContent = document.createElement('p');
			tostContent.innerHTML = "Support page published Successfully";
			tostRow.classList.add('open');
			tostRow.classList.add('success');
			tostRow.append(tostContent);
		} else {
			let tostContent = document.createElement('p');
			tostContent.innerHTML = "Support page published Failed";
			tostRow.classList.add('open');
			tostRow.classList.add('failed');
			tostRow.append(tostContent);
		}
		setTimeout(function() {
			supportPublish.classList.remove('loading');
			$('.tost-top').toggleClass('open');
			$('.tost-top').find('p').remove();
			$('.page-container').removeClass('loading');
			window.location.reload();
		}, 2000);
	});
	// localStorage.setItem("support_json",post_data);

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
