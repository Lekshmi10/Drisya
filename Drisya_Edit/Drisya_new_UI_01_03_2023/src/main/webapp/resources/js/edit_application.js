var result;
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
	getApi("./api/applications", function(response) {

		result = JSON.parse(response);

		populateSideMenu(result.applicationSideMenu.data);

		//console.log("resp is",result.applicationSideMenu.data);

		populateMoneyTransfer(result.moneyTransfer.data);

		populateExternalLinkMenu(result.externalLink.data);

		populateRightPane(result.applications.data);

		populateLeftPane(result.applicationsWithADLogin.data);

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

function populateSideMenu(data) {
	//console.log("Menu",data);
	var ul = document.getElementById("sidemenu_items-list");
	ul.innerHTML = "";
	for (let i = 0; i < data.length; i++) {
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl"   id="side_text-"  value="'
				+ data[i].text
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl" id="side_url-" value="'
				+ data[i].url
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <span class="list-ctrl">\n'
				+ '                                          <button class="delete-list" id="delete_value-"></button>\n'
				+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
				+ '                                          <button class="save-list"></button>\n'
				+ '                                      </span>\n';

		ul.prepend(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});
	}
}

function populateMoneyTransfer(data) {

	var ul = document.getElementById("money_items-list");
	ul.innerHTML = "";
	for (let i = (data.length - 1); i >= 0; i--) {
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl"   id="money_text-"  value="'
				+ data[i].text
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl" id="money_url-" value="'
				+ data[i].url
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <span class="list-ctrl">\n'
				+ '                                          <button class="delete-list" id="delete_value-"></button>\n'
				+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
				+ '                                          <button class="save-list"></button>\n'
				+ '                                      </span>\n';

		ul.appendChild(li);

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
function populateExternalLinkMenu(data) {

	//console.log("external data is " + JSON.stringify(data));
	var ul = document.getElementById("external_items-list");
	ul.innerHTML = "";
	for (let i = (data.length - 1); i >= 0; i--) {
		var flag_value;
		if (data[i].flag == true) {
			flag_value = 'checked';
		} else {
			flag_value = 'unchecked';
		}
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl"   id="ext_text-"  value="'
				+ data[i].text
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl" id="ext_url-" value="'
				+ data[i].url
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="togle-btn-row">\n'
				+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="external_flag" '
				+ flag_value
				+ '>'
				+ '<span class="toggleLabel"></span>\n'
				+ '<span class="btn-label">New</span>'
				+ '                                      </div>\n'
				+ '                                      <span class="list-ctrl">\n'
				+ '                                          <button class="delete-list" id="delete_value-"></button>\n'
				+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
				+ '                                          <button class="save-list"></button>\n'
				+ '                                      </span>\n';

		ul.appendChild(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});
	}
}

function populateLeftPane(data) {

	var ul = document.getElementById("left_pane_items-list");
	ul.innerHTML = "";
	for (let i = (data.length - 1); i >= 0; i--) {
		var flag_value;
		if (data[i].flag == true) {
			flag_value = 'checked';
		} else {
			flag_value = 'unchecked';
		}
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl"   id="left_text-"  value="'
				+ data[i].text
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl" id="left_url-" value="'
				+ data[i].url
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="togle-btn-row">\n'
				+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="left_flag" '
				+ flag_value
				+ '>'
				+ '<span class="toggleLabel"></span>\n'
				+ '<span class="btn-label">New</span>'
				+ '                                      </div>\n'
				+ '                                      <span class="list-ctrl">\n'
				+ '                                          <button class="delete-list" id="delete_value-"></button>\n'
				+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
				+ '                                          <button class="save-list"></button>\n'
				+ '                                      </span>\n';

		ul.appendChild(li);

		$('.delete-list').click(function(e) {
			e.preventDefault();
			$(this).parent().parent('.drag-list').remove();
		});
	}
}

function populateRightPane(data) {

	var ul = document.getElementById("right_pane_items-list");
	ul.innerHTML = "";
	for (let i = (data.length - 1); i >= 0; i--) {
		var flag_value;
		if (data[i].flag == true) {
			flag_value = 'checked';
		} else {
			flag_value = 'unchecked';
		}
		var li = document.createElement("li")
		li.className = "drag-list";
		li.id = "drag-list_" + i;
		li.innerHTML = '<div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl"   id="right_text-"  value="'
				+ data[i].text
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="input-row">\n'
				+ '                                          <input type="text" class="input-ctrl" id="right_url-" value="'
				+ data[i].url
				+ '">\n'
				+ '                                      </div>\n'
				+ '                                      <div class="togle-btn-row">\n'
				+ '                                           <input type="checkbox" class="toggle-btn input-ctrl"  id="right_flag" '
				+ flag_value
				+ '>'
				+ '<span class="toggleLabel"></span>\n'
				+ '<span class="btn-label">New</span>'
				+ '                                      </div>\n'
				+ '                                      <span class="list-ctrl">\n'
				+ '                                          <button class="delete-list" id="delete_value-"</button>\n'
				+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
				+ '                                          <button class="save-list"></button>\n'
				+ '                                      </span>\n';

		ul.appendChild(li);

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

function addMenu(id) {

	let text_span = document.createElement("span");
	text_span.className = "validate-text";
	let url_span = document.createElement("span");
	url_span.className = "validate-text";

	switch (id) {
	case "sidemenu_add":

		var title = document.getElementById("side_title").value;
		var url = document.getElementById("side_url").value;

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

		} else {
			var ul = document.getElementById("sidemenu_items-list");
			var li = document.createElement("li");
			li.className = "drag-list";
			li.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" value="'
					+ title
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" value="'
					+ url
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			ul.prepend(li);
		}
		document.getElementById("side_title").value = '';
		document.getElementById("side_url").value = '';
		break;

	case "extmenu_add":

		var title = document.getElementById("ext_title").value;
		var url = document.getElementById("ext_url").value;

		if (title.length == 0 || url.length == 0) {

			let errorText = document.getElementById("ext-text-add");
			let errorUrl = document.getElementById("ext-url-add");

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

		} else {
			var ul = document.getElementById("external_items-list");
			let checkbox = document.getElementById("add_ext_flag");
			if (checkbox.checked == true) {
				var li = document.createElement("li");
				li.className = "drag-list new";

				li.innerHTML = '<div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl"   id="ext_text-"  value="'
						+ title
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl" id="ext_url-" value="'
						+ url
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="togle-btn-row">\n'
						+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="external_flag" checked>'
						+ '<span class="toggleLabel"></span>\n'
						+ '<span class="btn-label">New</span>'
						+ '                                      </div>\n'
						+ '                                      <span class="list-ctrl">\n'
						+ '                                          <button class="delete-list" id="delete_value-"></button>\n'
						+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
						+ '                                          <button class="save-list"></button>\n'
						+ '                                      </span>\n';

				ul.prepend(li);
				document.getElementById("ext_title").value = '';
				document.getElementById("ext_url").value = '';
				document.getElementById("add_ext_flag").checked = false;

			} else {
				var li = document.createElement("li");
				li.className = "drag-list";

				li.innerHTML = '<div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl"   id="ext_text-"  value="'
						+ title
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl" id="ext_url-" value="'
						+ url
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="togle-btn-row">\n'
						+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="external_flag" unchecked>'
						+ '<span class="toggleLabel"></span>\n'
						+ '<span class="btn-label">New</span>'
						+ '                                      </div>\n'
						+ '                                      <span class="list-ctrl">\n'
						+ '                                          <button class="delete-list" id="delete_value-"></button>\n'
						+ '                                          <button class="edit-list" id="edit_side_menu-"></button>\n'
						+ '                                          <button class="save-list"></button>\n'
						+ '                                      </span>\n';

				ul.prepend(li);
				document.getElementById("ext_title").value = '';
				document.getElementById("ext_url").value = '';
			}
		}

		break;

	case "money_add":

		var title = document.getElementById("money_title").value;
		var url = document.getElementById("money_url").value;

		if (title.length == 0 || url.length == 0) {

			let errorText = document.getElementById("money-text-add");
			let errorUrl = document.getElementById("money-url-add");

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

		} else {
			var ul = document.getElementById("money_items-list");
			var li = document.createElement("li");
			li.className = "drag-list";
			li.innerHTML = '<div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl"  value="'
					+ title
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <div class="input-row">\n'
					+ '                                          <input type="text" class="input-ctrl" value="'
					+ url
					+ '">\n'
					+ '                                      </div>\n'
					+ '                                      <span class="list-ctrl">\n'
					+ '                                          <button class="delete-list"></button>\n'
					+ '                                          <button class="edit-list"></button>\n'
					+ '                                          <button class="save-list"></button>\n'
					+ '                                      </span>';

			ul.prepend(li);
		}
		document.getElementById("money_title").value = '';
		document.getElementById("money_url").value = '';
		break;

	case "right_add":

		var title = document.getElementById("right_title").value;
		var url = document.getElementById("right_url").value;

		if (title.length == 0 || url.length == 0) {

			let errorText = document.getElementById("right-text-add");
			let errorUrl = document.getElementById("right-url-add");

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

		} else {
			var ul = document.getElementById("right_pane_items-list");
			let flag = document.getElementById("add_right_flag");
			if (flag.checked == true) {
				var li = document.createElement("li");
				li.className = "drag-list new";
				li.innerHTML = '<div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl"  value="'
						+ title
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl" value="'
						+ url
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="togle-btn-row">\n'
						+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="right_flag" checked>'
						+ '<span class="toggleLabel"></span>\n'
						+ '<span class="btn-label">New</span>'
						+ '                                      </div>\n'
						+ '                                      <span class="list-ctrl">\n'
						+ '                                          <button class="delete-list"></button>\n'
						+ '                                          <button class="edit-list"</button>\n'
						+ '                                          <button class="save-list"></button>\n'
						+ '                                      </span>';

				ul.prepend(li);
				document.getElementById("right_title").value = '';
				document.getElementById("right_url").value = '';
				document.getElementById("add_right_flag").checked = false;
			} else {
				var li = document.createElement("li");
				li.className = "drag-list";
				li.innerHTML = '<div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl" value="'
						+ title
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl" value="'
						+ url
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="togle-btn-row">\n'
						+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="right_flag" unchecked>'
						+ '<span class="toggleLabel"></span>\n'
						+ '<span class="btn-label">New</span>'
						+ '                                      </div>\n'
						+ '                                      <span class="list-ctrl">\n'
						+ '                                          <button class="delete-list"></button>\n'
						+ '                                          <button class="edit-list"</button>\n'
						+ '                                          <button class="save-list"></button>\n'
						+ '                                      </span>';

				ul.prepend(li);
				document.getElementById("right_title").value = '';
				document.getElementById("right_url").value = '';
			}
		}

		break;

	case "left_add":

		var title = document.getElementById("left_title").value;
		var url = document.getElementById("left_url").value;

		if (title.length == 0 || url.length == 0) {

			let errorText = document.getElementById("left-text-add");
			let errorUrl = document.getElementById("left-url-add");

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

		} else {
			var ul = document.getElementById("left_pane_items-list");
			let check = document.getElementById("add_left_flag");
			if (check.checked == true) {
				var li = document.createElement("li");
				li.className = "drag-list new";
				li.innerHTML = '<div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl"  value="'
						+ title
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl"  value="'
						+ url
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="togle-btn-row">\n'
						+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="left_flag" checked>'
						+ '<span class="toggleLabel"></span>\n'
						+ '<span class="btn-label">New</span>'
						+ '                                      </div>\n'
						+ '                                      <span class="list-ctrl">\n'
						+ '                                          <button class="delete-list"></button>\n'
						+ '                                          <button class="edit-list"</button>\n'
						+ '                                          <button class="save-list"></button>\n'
						+ '                                      </span>';

				ul.prepend(li);
				document.getElementById("left_title").value = '';
				document.getElementById("left_url").value = '';
				document.getElementById("add_left_flag").checked = false;
			} else {
				var li = document.createElement("li");
				li.className = "drag-list";
				li.innerHTML = '<div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl" value="'
						+ title
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="input-row">\n'
						+ '                                          <input type="text" class="input-ctrl"  value="'
						+ url
						+ '">\n'
						+ '                                      </div>\n'
						+ '                                      <div class="togle-btn-row">\n'
						+ '                                           <input type="checkbox" class="toggle-btn input-ctrl" id="left_flag" unchecked>'
						+ '<span class="toggleLabel"></span>\n'
						+ '<span class="btn-label">New</span>'
						+ '                                      </div>\n'
						+ '                                      <span class="list-ctrl">\n'
						+ '                                          <button class="delete-list"></button>\n'
						+ '                                          <button class="edit-list"</button>\n'
						+ '                                          <button class="save-list"></button>\n'
						+ '                                      </span>';

				ul.prepend(li);
				document.getElementById("left_title").value = '';
				document.getElementById("left_url").value = '';
			}

		}

		break;

	}

	$('.delete-list').click(function(e) {
		e.preventDefault();
		$(this).parent().parent('.drag-list').remove();
	});

}

const application_publish = document.getElementById("application_publish");

application_publish.addEventListener('click', function(event) {
	$('.page-container').addClass('loading');
	application_publish.classList.add('loading');
	var side_data = [];
	var money_data = [];
	var ext_data = [];
	var right_data = [];
	var left_data = [];
	let applicationSideMenu = {};
	let moneyTransfer = {};
	let ext_Obj = {};
	let right_Obj = {};
	let left_Obj = {};

	// Get all input elements on the sidemenu
	const sidemenu = document.querySelector('#sidemenu_items-list');
	const sidevalues = sidemenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (sidevalues.length) - 1; i++) {

		if (i % 2 == 0) {

			const text = sidevalues[i];
			const url = sidevalues[i + 1];

			const text_value = text.value;
			const url_value = url.value;

			let obj = {
				"text" : text_value,
				"url" : url_value
			};

			side_data.unshift(obj);

		}

	}

	applicationSideMenu = {
		"data" : side_data
	}

	// Get all input elements on the money transfer
	const moneymenu = document.querySelector('#money_items-list');

	const moneyvalues = moneymenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (moneyvalues.length) - 1; i++) {

		if (i % 2 == 0) {

			const text = moneyvalues[i];
			const url = moneyvalues[i + 1];

			const text_value = text.value;
			const url_value = url.value;

			let money_obj = {
				"text" : text_value,
				"url" : url_value
			};

			money_data.unshift(money_obj);

		}

	}

	moneyTransfer = {
		"title" : "Money Transfer",
		"data" : money_data
	}

	// Get all input elements on the external
	const extmenu = document.querySelector('#external_items-list');

	const extvalues = extmenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (extvalues.length) - 1; i++) {

		if (i % 3 == 0) {

			const text = extvalues[i];
			const url = extvalues[i + 1];
			const flg = extvalues[i + 2];

			const text_value = text.value;
			const url_value = url.value;
			const flag_value = flg.checked;

			let ext_Menu = {
				"text" : text_value,
				"url" : url_value,
				"flag" : flag_value
			};

			ext_data.unshift(ext_Menu);

		}

	}

	ext_Obj = {
		"title" : "External Link",
		"data" : ext_data
	}

	// Get all input elements on the right
	const rightmenu = document.querySelector('#right_pane_items-list');

	const rightvalues = rightmenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (rightvalues.length) - 1; i++) {

		if (i % 3 == 0) {

			const text = rightvalues[i];
			const url = rightvalues[i + 1];
			const flg = rightvalues[i + 2];

			const text_value = text.value;
			const url_value = url.value;
			const flag_value = flg.checked;

			let right_Menu = {
				"text" : text_value,
				"url" : url_value,
				"flag" : flag_value
			};

			right_data.unshift(right_Menu);

		}

	}

	right_Obj = {
		"data" : right_data
	}

	// Get all input elements on the left
	const leftmenu = document.querySelector('#left_pane_items-list');

	const leftvalues = leftmenu.querySelectorAll('.input-ctrl');

	// Loop through each input element and get its value

	for (let i = 0; i < (leftvalues.length) - 1; i++) {

		if (i % 3 == 0) {

			const text = leftvalues[i];
			const url = leftvalues[i + 1];
			const flg = leftvalues[i + 2];

			const text_value = text.value;
			const url_value = url.value;
			const flag_value = flg.checked;

			let left_Menu = {
				"text" : text_value,
				"url" : url_value,
				"flag" : flag_value
			};

			left_data.unshift(left_Menu);

		}

	}

	left_Obj = {
		"data" : left_data
	}

	var post_data = JSON.stringify({
		"applicationSideMenu" : applicationSideMenu,
		"applications" : right_Obj,
		"applicationsWithADLogin" : left_Obj,
		"externalLink" : ext_Obj,
		"moneyTransfer" : moneyTransfer,
	});

	postApi("./api/applicationPublish", post_data, function(response, status) {
		// alert("Application page published successfully");
		const tostRow = document.querySelector('#publish-success');
		if (status == 200) {
			let tostContent = document.createElement('p');
			tostContent.innerHTML = "Application page published Successfully";
			tostRow.classList.add('open');
			tostRow.classList.add('success');
			tostRow.append(tostContent);
		} else {
			let tostContent = document.createElement('p');
			tostContent.innerHTML = "Application page published Failed";
			tostRow.classList.add('open');
			tostRow.classList.add('failed');
			tostRow.append(tostContent);
		}
		setTimeout(function() {
			application_publish.classList.remove('loading');
			$('.tost-top').toggleClass('open');
			$('.tost-top').find('p').remove();
			$('.page-container').removeClass('loading');
			window.location.reload();
		}, 2000);
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