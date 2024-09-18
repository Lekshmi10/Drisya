let createMenu = document.getElementById("create-menu");
var manuRow = document.getElementById("group-row");
var tostRow = document.getElementById("tost-row");
function getApi(url, callback) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			callback(this.responseText);
		}
	}
	xhr.open('GET', url, true);
	xhr.send('');
}

getApi("./api/home",function(response) {
			var data = JSON.parse(response);
			data = data.footer;
			// //console.log("data",data);

			for (let i = 0; i < data.sectionData.length; i++) {
				var currentData = data.sectionData[i];
				var menuList = currentData.menu;
				// //console.log('currentData',currentData);
				var div = document.createElement('div');
				var groupBody = document.createElement('div');
				groupBody.classList.add('group-body');
				div.classList.add('menu-group');
				div.innerHTML = '<div class="group-title">\n'
						+ '<span class="drag-icon"></span> '
						+ '<input class="menu-title" type="text" value="'
						+ currentData.title
						+ '" placeholder="Menu Title">\n'
						+ '<div class="menu-ctrl">\n'
						+ '<button class="delete-menu delete-group"><i class="fa fa-trash-o" aria-hidden="true"></i></button>\n'
						+ '<button class="add-menu add-menu-list" onclick="addMenuList(this)"><i class="fa fa-plus-square-o" aria-hidden="true"></i></button>\n'
						+ '<button class="down-arrow f-menu-collapse"><i class="fa fa-angle-down" aria-hidden="true"></i></button>\n'
						+ '</div>\n' + '</div>\n'
				// //console.log("menuList Length",menuList.length);
				for (let j = 0; j < currentData.menu.length; j++) {
					var currentMenu = menuList[j];
					// //console.log("currentMenu",currentMenu)
					var menuList = document.createElement('div');
					menuList.classList.add('menu-list');
					menuList.innerHTML = '<span class="drag-icon"></span> '
							+ '<div class="menu-row">\n'
							+ '<input type="text"  class="menu-list-input menu-label" value="'
							+ currentData.menu[j].text
							+ '" placeholder="Label">\n'
							+ '<input type="text"  class="menu-list-input menu-url" value="'
							+ currentData.menu[j].url
							+ '"  placeholder="Url">\n'
							+ '</div>\n'
							+ '<div class="menu-ctrl">\n'
							+ '<button class="delete-menu delete-menu-list"><i class="fa fa-trash-o" aria-hidden="true"></i></button>\n'
							+ '</div>'
					groupBody.prepend(menuList);
				}
				div.appendChild(groupBody);
				manuRow.appendChild(div);
			}
		});

//MENU COLAPSE
$(document).on('click', '.f-menu-collapse', function(e) {
	e.preventDefault();
	$(this).toggleClass('open');
	$(this).parents('.menu-group').toggleClass('active');
	$(this).parents('.menu-group').find('.group-body').slideToggle();
});

$(document).on('click', '.delete-group', function() {
	$(this).parents('.menu-group').remove();
});
$(document).on('click', '.delete-menu-list', function() {
	$(this).parents('.menu-list').remove();
});

createMenu
		.addEventListener(
				"click",
				function() {

					if ($('.menu-title').val().length === 0) {
						tostRow.classList.add('failed');
						tostRow.classList.add('open');
						tostRow.innerHTML = "<p>please fill the input field</p>";
					} else {
						var div = document.createElement('div');
						div.classList.add('menu-group');
						div.innerHTML = '<div class="group-title">\n'
								+ '<span class="drag-icon"></span> '
								+ '<input class="menu-title" type="text" placeholder="Menu Title">\n'
								+ '<div class="menu-ctrl">\n'
								+ '<button class="delete-menu delete-group"><i class="fa fa-trash-o" aria-hidden="true"></i></button>\n'
								+ '<button class="add-menu" onclick="addMenuList(this)"><i class="fa fa-plus-square-o" aria-hidden="true"></i></button>\n'
								+ '<button class="down-arrow f-menu-collapse"><i class="fa fa-angle-down" aria-hidden="true"></i></button>\n'
								+ '</div>\n' + '</div>\n'
								+ '<div class="group-body"></div>\n'
						manuRow.prepend(div);
					}

				});

function addMenuList(item) {
	if ($('.menu-list-input').val().length === 0) {
		tostRow.classList.add('failed');
		tostRow.classList.add('open');
		tostRow.innerHTML = "<p>please fill the input field</p>";
	} else {
		let parentElm = item.parentElement.parentElement.parentElement;
		let menuList = document.createElement('div');
		menuList.classList.add('menu-list');
		menuList.innerHTML = '<span class="drag-icon"></span> '
				+ '<div class="menu-row">\n'
				+ '<input type="text"  class="menu-list-input menu-label" placeholder="Label">'
				+ '<input type="text"  class="menu-list-input menu-url" placeholder="Url">'
				+ '</div>'
				+ '<div class="menu-ctrl">'
				+ '<button class="delete-menu delete-menu-list"><i class="fa fa-trash-o" aria-hidden="true"></i></button>\n'
				+ '</div>'
		// groupBody.append(menuList);
		// //console.log("groupBody",);
		$(parentElm).find('.group-body').prepend(menuList);
		$(parentElm).find('.group-body').addClass('open');
	}

}
$(document).on('click', '.tost-row', function() {
	$(this).removeClass('open');
});
$("input").keyup(function() {
	$(".add-btn").removeClass('pointer-none');
});
