var result;
var validation = /[a-z0-9-\.]+\.[a-z]{2,4}\/?([^\s<>\#%"\,\{\}\\|\\\^\[\]`]+)?$/;
var role;
var validateElement = document.createElement('span');
validateElement.classList.add('validate-text');

window.onload = function () {
    getApi("./api/home", function (response) {
        result = JSON.parse(response);
        // console.log("e", result);
        // console.log("Banner Image", result.images.data);
        populateHomeSideMenu(result.sideMenu.data);
        populateBlurbs(result.blurb.data);
        fetchVideoBanner(result.videos.data);
        fetchNews(result.newsAndEvents.data);
        populateAlerts(result.alerts.alerts);
        // populateMiscelleneous(result.miscellaneous.data);
        populateEmpSearch(result.employeeSearch.url);
        populateBanner(result.images.data);
        populateCeo(result.videos.data);
        populateSong(result.music.audioText);
    });


    role=document.getElementById("user-role").value;
    console.log("role",role);
    if(role=="Drisya_HR"){

        window.location.href="/retirement"

    }else if(role=="Drisya_Marketing_Team"){

        document.getElementById("retirement_data").style.opacity=0.5;
        document.getElementById("retirement_data").style.pointerEvents="none";

    }else if(role=="Drisya_ADMIN"){



    }else{

        window.location.href="/access"
    }


}

function getApi(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            callback(this.responseText);
        }
    });
    xhr.open("GET", url);
    xhr.send();
}



$(document).ready(function () {
    $('.add-video-btn').click(function () {
        $('.add-video-modal').addClass('open');
    });
    $('.close-video').click(function () {
        $('.add-video-modal').removeClass('open');
    });
});


function addHomeMenu(id) {

    if ($('.input-row .validate-text').length > 0) {
        $('.validate-text').remove();
    }

    var text_span = document.createElement("span");
    text_span.className = "validate-text";

    var url_span = document.createElement("span");
    url_span.className = "validate-text";

    var img_span = document.createElement("span");
    img_span.className = "validate-text";

    switch (id) {

        case "homeSideMenu":

            let homeSidetitle = document.getElementById("homeSide-title").value;
            let homeSideurl = document.getElementById("homeSide-url").value;

            if (homeSidetitle.length == 0 || homeSideurl.length == 0 ) {

                let errorDiv = document.getElementById("home_title");
                let errorUrl = document.getElementById("home_url");

                if (homeSideurl.length == 0 && homeSidetitle.length == 0) {
                    text_span.innerHTML = "Title not be blank";
                    errorDiv.append(text_span);
                    url_span.innerHTML = "Url not be blank";
                    errorUrl.append(url_span);
                } else if (homeSidetitle.length == 0) {
                    text_span.innerHTML = "Title not be blank";
                    errorDiv.append(text_span);
                } else if (homeSideurl.length == 0) {
                    url_span.innerHTML = "Url is not be blank";
                    errorUrl.append(url_span);
                }

                document.getElementById("homeSide-title").value = '';
                document.getElementById("homeSide-url").value = '';
            } else {

                var homeSideUl = document.getElementById("homeMenu");
                var homeSideLi = document.createElement("li");
                homeSideLi.className = "drag-list";
                homeSideLi.innerHTML = '<div class="input-row">\n' +
                    '<input type="text" class="input-ctrl" id="side_text-" value="' + homeSidetitle + '">\n' +
                    '</div>\n' +
                    '<div class="input-row">\n' +
                    '<input type="text" class="input-ctrl" id="side_url-" value="' + homeSideurl + '">\n' +
                    '</div>\n' +
                    '<span class="list-ctrl">\n' +
                    '<button class="delete-list"></button>\n' +
                    '<button class="edit-list" id="edit_side_menu"></button>\n' +
                    '<button class="save-list"></button>\n' +
                    ' </span>';

                homeSideUl.prepend(homeSideLi);

                document.getElementById("homeSide-title").value = '';
                document.getElementById("homeSide-url").value = '';

            }
            break;


        case "homeBlurbs":


            let blurb_File = document.getElementById("blurbFile");
            let blurb_Url = document.getElementById("blurbUrl").value;



            var fileUpload1 = $("#blurbFile")[0];


            var reader = new FileReader();
// Read the contents of Image File.
            reader.readAsDataURL(fileUpload1.files[0]);

            reader.onloadend = function (y) {

                var image1 = new Image();
                image1.src = y.target.result;
                image1.onload = function () {

                    // document.write('String Output: ', reader.result);
                    // console.log("result", reader.result);
                    let height = this.height;
                    let width = this.width;
                    let blurbSize = (blurb_File.files.item(0).size) / 1024;


                    if ((height != 110 || width != 350) || blurb_File.length == 0 || blurb_Url.length == 0 || !validation.test(blurb_Url) || blurbSize > 450) {

                        let errorDiv = document.getElementById("homefile");
                        let errorUrl = document.getElementById("homeurl");

                        if (blurb_File.files.length == 0 && blurb_Url.length == 0) {

                            url_span.innerHTML = "Url not be blank";
                            errorUrl.append(url_span);

                        } else if (blurb_Url.length == 0) {
                            url_span.innerHTML = "Url is not be blank";
                            errorUrl.append(url_span);
                        } else if (!validation.test(blurb_Url)) {
                            url_span.innerHTML = "Please enter valid Url";
                            errorUrl.append(url_span);
                        } else if ((height !== 110 || width !== 350 || blurbSize > 450)) {
                            img_span.innerHTML = "size and resolution should between the 350px X 110px and 450kb "
                            errorDiv.append(img_span);

                        }
                        document.getElementById("blurbFile").value = '';
                        document.getElementById("blurbUrl").value = '';
                    } else {

                        var homeBlurbsUl = document.getElementById("home_blurbs");
                        var homeBlurbsLi = document.createElement("li");
                        homeBlurbsLi.className = "drag-list blurbs";
                        homeBlurbsLi.innerHTML = '<div class="view-blurb-row">' +
                            '<div class="image-row">' +
                            '<img src=' + reader.result + '  class="input_values"> ' +
                            '</div>' + '<div class="input-row">' +
                            '<input type="text" class="input-ctrl input_values"   value="' + blurb_Url + '">' +
                            '</div>' +
                            '<span class="list-ctrl">' +
                            '<button class="edit-blurb"></button>' +
                            '<button class="delete-list"></button>' +
                            '</span>' +
                            '</div>' +
                            '<div class="edit-blurb-row">' +
                            '<div class="edit-blurb-form">' +
                            '<div class="input-row">' +
                            '<label for="" class="input-label">Image</label>' +
                            '<input type="file" class="input-file edit-blurb-image" value="' + reader.result + '" >' +
                            '</div>' +
                            '<div class="input-row">' +
                            '<label for="" class="input-label">Url</label>' +
                            '<input type="text" class="input-file edit-blurb-url" value="' + blurb_Url + '" autocomplete="off" >' +
                            '</div>' +
                            '<div class="btn-row span-2">' +
                            '<button class="form-submit update-blurb" onclick="blurbUpdate(this)">Update</button>' +
                            '</div>' +
                            '</div> ' +
                            '</div>';

                        homeBlurbsUl.prepend(homeBlurbsLi);

                        document.getElementById("blurbFile").value = '';
                        document.getElementById("blurbUrl").value = '';
                    }


                };
            }

            break;


        case "addNews":
            let newsTitle = document.getElementById("news-title").value;
            let newsDescription = document.getElementById("news-description").value;
            // let newsSiz= document.getElementById("news-image").value;
            var fileUpload = $("#news-image")[0];

            var reader_4 = new FileReader();
// Read the contents of Image File.
            reader_4.readAsDataURL(fileUpload.files[0]);
            reader_4.onload = function (e) {
                // Initiate the JavaScript Image object.
                var image = new Image();
                // Set the Base64 string return from FileReader as source.
                image.src = e.target.result;

                image.onload = function () {
                    // Determine the Height and Width.
                    var height = this.height;
                    var width = this.width;
                    // var videoBannerUrl =
					// document.getElementById("banner-video-url").value;
                    let newSize = document.getElementById("news-image");
                    let size = (newSize.files.item(0).size) / 1024;



                   if (height !== 250 || width !== 420 ||newsTitle.length == 0 || newsDescription.length == 0 || size >450||newSize.files.length==0) {


                        let errorDiv = document.getElementById("homeNewsTitle");
                        let errorUrl = document.getElementById("homeNewsDescription");
                        let errorImg = document.getElementById("homeNewsImage");


                        if (newsTitle.length == 0 && newsDescription.length == 0 ) {
                            text_span.innerHTML = "Not to be blank";
                            errorDiv.append(text_span);
                            url_span.innerHTML = "Not to be blank";
                            errorUrl.append(url_span);
                            // img_span.innerHTML="not to be blank "
                            // errorImg.append(img_span);
                        } else if (newsTitle.length == 0) {
                            text_span.innerHTML = "Not to be blank";
                            errorDiv.append(text_span);
                        } else if (newsDescription.length == 0) {
                            url_span.innerHTML = "Not to be blank";
                            errorUrl.append(url_span);
                        }
                        else if( newSize.files.length==0)
                        {
                            img_span.innerHTML="not to be blank "
                            errorImg.append(img_span);
                        }
                        else if(height !== 250 ||width !== 420 || size >450){
                            img_span.innerHTML="size and resolution should between the 420px X 250px and 450kb "
                            errorImg.append(img_span);

                        }


                        document.getElementById("news-title").value='';
                        document.getElementById("news-description").value='';
                        document.getElementById("news-image").value='';


                    


                    }else{

                        let newsDiv = document.getElementById("news-fetchList");
                        let newsList = document.createElement('div');
                        newsList.className = "news-list"
                        newsList.id = "newsList";
                        newsList.innerHTML = '<div class="view-news">' +
                            ' <div class="news-image"  id="image-news-">' +
                            '<img src=' + reader_4.result +' alt="" class="news-data">' +
                            ' </div>' +
                            '<div class="news-content" id="content-news-">' +
                            ' <strong class="news-data">' + newsTitle + '</strong>' +
                            '<p class="news-data">' + newsDescription + '</p>\n' +
                            '</div>' +
                            '<span class="list-ctrl">' +
                            '<button class="edit-list news-edit"></button>' +
                            '<button class="delete-list"></button>' +
                            '</span>'+
                            '</div>'+
                            '<div class="edit-news">' +
                            '<div class="form-card edit-news-event">' +
                            '<div class="input-row news-event-list" id="">' +
                            '<label for="" class="input-label">Title</label>' +
                            '<input type="text" class="input-ctrl update-news-title" placeholder="Enter Title" value="' + newsTitle + '" autocomplete="off">' +
                            '</div>' +
                            '<div class="input-row news-event-list">' +
                            '<label for="" class="input-label">Image</label>' +
                            '<input type="file" class="input-file update-news-image">' +
                            '</div>\n' +
                            '<div class="input-row news-event-list span-2">' +
                            '<label for="" class="input-label">Description</label>' +
                            '<textarea class="text-ctrl input-ctrl update-news-description" placeholder="Description">' + newsDescription + '</textarea>' +
                            '</div>\n' +
                            '<div class="btn-row span-2">' +
                            '<button class="form-submit update-news" onclick="newsUpdate(this)">Update</button>' +
                            '</div>' +
                            '</div>'+
                            '</div>'+
                            '</div>';
                        newsDiv.prepend(newsList);
                        document.getElementById("news-title").value='';
                        document.getElementById("news-description").value='';
                        document.getElementById("news-image").value='';
                    }
                };

            }

            break;

        case "empSearch":

            var textEmp = document.getElementById("textEmp").value;

            if(textEmp.length==0){

                text_span.innerHTML = "Not to be blank";
                document.getElementById("emp-label").append(text_span);
            }

            else{
                let empDiv = document.getElementById("emp-menu");
                let empList = document.createElement('li');
                empList.className = "drag-list";
                empList.innerHTML = '<div class="input-row">' +
                    '<input type="text" class="input-ctrl" value="' + textEmp + '">' +
                    '</div>' + '<span class="list-ctrl">' +
                    '<button class="edit-list"></button>' +
                    '<button class="save-list"></button>' +
                    '<button class="delete-list"></button>' +
                    '</span>' +
                    '</li>'

                empDiv.prepend(empList);
            }
            break;




        case "addAlerts":
            var alert = document.getElementById("textAlert").value;

            if (alert.length == 0) {
                text_span.innerHTML = "Not to be blank";
                document.getElementById("alert-label").append(text_span);


            } else {
                let alertDiv = document.getElementById("alert-menu");
                let alertList = document.createElement('li');
                alertList.className = "drag-list";
                alertList.innerHTML = '<div class="input-row">' +
                    '<input type="text" class="input-ctrl" value="' + alert + '">' +
                    '</div>' + '<span class="list-ctrl">' +
                    '<button class="edit-list"></button>' +
                    '<button class="save-list"></button>' +
                    '<button class="delete-list"></button>' +
                    '</span>' +
                    '</li>'

                alertDiv.prepend(alertList);
            }
            break;

        // case "miscelleneous":
        //
        // let miscelleneousTitle =
		// document.getElementById("miscelleneous_title").value;
        // let miscelleneousImage =
		// document.getElementById("miscelleneous_file");
        // let miscelleneousColor =
		// document.getElementById("miscelleneous_color").value;
        // let miscellenouesUrl =
		// document.getElementById("miscelleneous_url").value;
        //
        // // //console.log("color",miscelleneousColor)
        // if (miscelleneousTitle.length == 0 || miscellenouesUrl.length == 0 ||
		// !validation.test(miscellenouesUrl)) {
        //
        // let errorDiv = document.getElementById("missTitle");
        // let errorUrl = document.getElementById("missUrl");
        //
        // if (miscelleneousTitle.length == 0 && miscellenouesUrl.length == 0) {
        // text_span.innerHTML = "Not to be blank";
        // errorDiv.append(text_span);
        // url_span.innerHTML = "Not to be blank";
        // errorUrl.append(url_span);
        // } else if (miscellenouesUrl.length == 0) {
        // text_span.innerHTML = "Not to be blank";
        // errorUrl.append(text_span);
        // } else if (miscelleneousTitle.length == 0) {
        // text_span.innerHTML = "Not to be blank";
        // errorDiv.append(text_span);
        // } else if (!validation.test(miscellenouesUrl)) {
        // url_span.innerHTML = "Please enter valid Url";
        // errorUrl.append(url_span);
        // }
        //
        // document.getElementById("miscelleneous_title").value = '';
        // document.getElementById("miscelleneous_url").value = '';
        // document.getElementById("miscelleneous_color").value = '';
        // document.getElementById("miscelleneous_file").value = '';
        //
        //
        // } else {
        // let reader_2 = new FileReader();
        //
        //
        // let m = miscelleneousImage.files[0];
        //
        // reader_2.onloadend = function () {
        // let miscelleneous_list =
		// document.getElementById("miscelleneous_list");
        // var miscelleList = document.createElement("li");
        // miscelleList.className = "drag-list miscell-list";
        // miscelleList.innerHTML = '<span style="background-color:' +
		// miscelleneousColor + '"><input type="color" class="input-ctrl
		// miss_values" value="' + miscelleneousColor + '"></span>' +
        // '<img src=' + reader_2.result + ' alt="" class="miss_values">' +
        // '<input type="text" class="input-ctrl d-none" value=' +
		// reader_2.result + '>' +
        // '<div class="input-row">' +
        // '<input type="text" class="input-ctrl miss_values" value="' +
		// miscelleneousTitle + '">' +
        // '</div>' +
        // '<div class="input-row">' +
        // '<input type="text" class="input-ctrl miss_values" value="' +
		// miscellenouesUrl + '">' +
        // '</div>' +
        // '<span class="list-ctrl">' +
        // '<button class="edit-list"></button>' +
        // '<button class="save-list"></button>' +
        // '<button class="delete-list"></button>' +
        // '</span>' +
        // '</li>'
        //
        //
        // //console.log("color", miscelleneousColor);
        // miscelleneous_list.prepend(miscelleList);
        //
        // document.getElementById("miscelleneous_title").value = '';
        // document.getElementById("miscelleneous_url").value = '';
        // document.getElementById("miscelleneous_color").value = '';
        // document.getElementById("miscelleneous_file").value = '';
        // }
        //
        // reader_2.readAsDataURL(m);
        // }
        // break;
    }


    $('.delete-list').click(function (e) {
        e.preventDefault();
        $(this).parent().parent('.drag-list').remove();
    });
}


function populateHomeSideMenu(l) {


    var homeMenu = document.getElementById("homeMenu");
    if (l.length == 0) {

    } else {
        homeMenu.innerHTML = "";
        for (let i = (l.length - 1); i >= 0; i--) {
            var li = document.createElement("li")
            li.className = "drag-list";
            li.id = "drag-list_" + i;
            li.innerHTML = '<div class="input-row">\n' +
                ' <input type="text" class="input-ctrl"   id="side_text-' + i + '"  value="' + l[i].text + '">\n' +
                '  </div>\n' +
                '   <div class="input-row">\n' +
                '   <input type="text" class="input-ctrl" id="side_url-' + i + '" value="' + l[i].url + '">\n' +
                '    </div>\n' +
                '   <span class="list-ctrl">\n' +
                '   <button class="delete-list" id="delete_value-"' + i + ' ></button>\n' +
                '   <button class="edit-list" id="edit_side_menu-"' + i + ' ></button>\n' +
                '    <button class="save-list"></button>\n' +
                '    </span>\n';

            homeMenu.appendChild(li);

            $('.delete-list').click(function (e) {
                e.preventDefault();
                $(this).parent().parent('.drag-list').remove();
            });


        }
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



// function populateMiscelleneous(k) {
// //console.log("k", k);
// let miscelleneous_list = document.getElementById("miscelleneous_list");
// miscelleneous_list.innerHTML = "";
// for (let i = (k.length - 1); i >= 0; i--) {
// // //console.log("k",k[i].title );
// var miscelleList = document.createElement("li");
// miscelleList.className = "drag-list miscell-list";
// miscelleList.innerHTML = '<span style="background-color:' + k[i].color +
// '"><input type="color" class="input-ctrl miss_values" value="' + k[i].color +
// '"></span>' +
// '<img src=' + k[i].image + ' alt="" class="miss_values">' +
// '<input type="text" class="input-ctrl d-none" value="' + k[i].image + '">' +
// '<div class="input-row">' +
// '<input type="text" class="input-ctrl miss_values" value="' + k[i].content +
// '">' +
// '</div>' +
// '<div class="input-row">' +
// '<input type="text" class="input-ctrl miss_values" value="' + k[i].url + '">'
// +
// '</div>' +
// '<span class="list-ctrl">' +
// '<button class="edit-list"></button>' +
// '<button class="save-list"></button>' +
// '<button class="delete-list"></button>' +
// '</span>' +
// '</li>'
//
// miscelleneous_list.appendChild(miscelleList);
//
// $('.delete-list').click(function (e) {
// e.preventDefault();
// $(this).parent().parent('.drag-list').remove();
// });
//
//
// }
// }

function populateBlurbs(b) {

    var homeBlurbsUl = document.getElementById("home_blurbs");
    homeBlurbsUl.innerHTML = "";
    for (let i = (b.length - 1); i >= 0; i--) {
        var homeBlurbsLi = document.createElement("li");
        homeBlurbsLi.className = "drag-list blurbs";
        homeBlurbsLi.innerHTML = '<div class="view-blurb-row">'+
            '<div class="image-row">' +
            '<img src=' + b[i].thumbnail + ' id="homeBlurb-img-' + i + '" class="input_values"> ' +
            '</div>' + '<div class="input-row">' +
            '<input type="text" class="input-ctrl input_values"  id="homeBlurb-Url-' + i + '" value="' + b[i].url + '">' +
            '</div>' +
            '<span class="list-ctrl">'+
            '<button class="edit-blurb"></button>' +
            '<button class="delete-list"></button>'+
            '</span>' +
            '</div>'+
            '<div class="edit-blurb-row">'+
            '<div class="edit-blurb-form">' +
            '<div class="input-row">'+
            '<label for="" class="input-label">Image</label>'+
            '<input type="file" class="input-file edit-blurb-image" onchange="updateBlurbImage(this)" >'+
            '</div>'+
            '<div class="input-row">'+
            '<label for="" class="input-label">Url</label>'+
            '<input type="text" class="input-file edit-blurb-url" value="' + b[i].url + '" >'+
            '</div>'+
            '<div class="btn-row span-2">' +
            '<button class="form-submit update-blurb" onclick="blurbUpdate(this)">Update</button>' +
            '</div>' +
            '</div> '+
            '</div>'

        homeBlurbsUl.append(homeBlurbsLi);

        $('.delete-list').click(function (e) {
            e.preventDefault();
            $(this).parent().parent('.drag-list').remove();
        });
    }
}

function populateEmpSearch(s) {

    let employeeDiv = document.getElementById("emp-menu");
    if (s.length >0) {
    	
    	document.getElementById("empSearch").style.opacity=0.5;
    	document.getElementById("empSearch").style.pointerEvents='none';
    } 
        employeeDiv.innerHTML = "";
        // for (let i = (s.length - 1); i >= 0; i--) {
            let empList = document.createElement('li');
            empList.className = "drag-list";
            empList.innerHTML = '<div class="input-row">' +
                '<input type="text" class="input-ctrl" value="' + s + '">' +
                '</div>' + '<span class="list-ctrl">' +
                '<button class="edit-list"></button>' +
                '<button class="save-list"></button>' +
                '<button class="delete-list"></button>' +
                '</span>' ;

            employeeDiv.prepend(empList);

        
   // }
}


function updateBlurbImage(updateBlurbImg) {
    let blurbParentElm = updateBlurbImg.parentNode;
    // console.log("blurbParentElm",blurbParentElm);
    $(blurbParentElm).find(validateElement).remove();
    const file = updateBlurbImg.files[0];
    const reader = new FileReader();
    let fileSize = (file.size) / 1024;

    // //console.log("parentElm",parentElm);
    reader.onload = function() {
        const img = new Image();
        img.src = reader.result;
        img.onload = function() {
            const validWidth = 420;
            const validHeight = 250;
            const validSIze = 450;
            if (img.width !== validWidth || img.height !== validHeight) {
                updateBlurbImg.value='';
                validateElement.innerHTML = "Image dimension are within limits 420x250";
                blurbParentElm.appendChild(validateElement);
            } else if(validSIze <= fileSize) {
                updateBlurbImg.value='';
                validateElement.innerHTML = "Image size are within limits 450kb";
                blurbParentElm.appendChild(validateElement);
            }
            setTimeout(function () {
                if($(blurbParentElm).find(validateElement)){
                    $(validateElement).remove();
                }
            }, 5000);
        };
    };
    reader.readAsDataURL(file);
}

function blurbUpdate(updateBlurb) {
    var blurbRes = updateBlurb;
    let parentList = blurbRes.parentNode.parentNode.parentNode.parentNode;
    let parentElement = blurbRes.parentNode.parentNode;

    let blurbUrl = parentList.querySelector('.view-blurb-row input');
    let blurbImage = parentList.querySelector('.view-blurb-row img');
    let blurbNewImage = parentElement.querySelector('.edit-blurb-image');
    let blurbNewUrl = parentElement.querySelector('.edit-blurb-url');

    if(blurbNewUrl.value == ''){
    	blurbNewUrl.innerHTML = blurbUrl.value;
    }else {
        blurbUrl.value = blurbNewUrl.value;
    }

    if(blurbNewImage.files[0]){
        var file = blurbNewImage.files[0];
        var reader = new FileReader();
        reader.onload = function() {
            var base64String = reader.result.split(",")[1];

            blurbImage.src= 'data:image/png;base64,'+base64String;
        };
        reader.readAsDataURL(file);
    }


}

function fetchNews(f) {
    let newsDiv = document.getElementById("news-fetchList");
    if (f.length == 0) {
    } else {
        newsDiv.innerHTML = "";
        for (let i = (f.length - 1); i >= 0; i--) {
            let newsList = document.createElement('div');
            newsList.className = "news-list"
            newsList.id = "newsList" + i;
            newsList.innerHTML = '<div class="view-news">' +
                ' <div class="news-image"  id="image-news-' + i + '">' +
                '<img src=' + f[i].image + ' alt="" class="news-data">' +
                ' </div>' +
                '<div class="news-content" id="content-news-' + i + '">' +
                ' <strong class="news-data">' + f[i].title + '</strong>' +
                '<p class="news-data">' + f[i].text + '</p>\n' +
                '</div>' +
                '<span class="list-ctrl">' +
                '<button class="edit-list news-edit"></button>' +
                '<button class="delete-list"></button>' +
                '</span>'+
                '</div>'+
                '<div class="edit-news">' +
                '<div class="form-card edit-news-event">' +
                '<div class="input-row news-event-list">' +
                '<label for="" class="input-label">Title</label>' +
                '<input type="text" class="input-ctrl update-news-title" placeholder="Enter Title" value="' + f[i].title + '" autocomplete="off">' +
                '</div>' +
                '<div class="input-row news-event-list">' +
                '<label for="" class="input-label">Image</label>' +
                '<input type="file" class="input-file update-news-image" onchange="updateNewsImage(this)">' +
                '</div>\n' +
                '<div class="input-row news-event-list span-2">' +
                '<label for="" class="input-label">Description</label>' +
                '<textarea class="text-ctrl input-ctrl update-news-description" placeholder="Description">' + f[i].text + '</textarea>' +
                '</div>\n' +
                '<div class="btn-row span-2">' +
                '<button class="form-submit update-news" onclick="newsUpdate(this)">Update</button>' +
                '</div>' +
                '</div>'+
                '</div>'+
                '</div>';
            newsDiv.append(newsList);
        }
    }
}

function updateNewsImage(updateImg) {
    let parentElm = updateImg.parentNode;
    $(parentElm).find(validateElement).remove();
    const file = updateImg.files[0];
    const reader = new FileReader();
    let fileSize = (file.size) / 1024;

    // //console.log("parentElm",parentElm);
    reader.onload = function() {
        const img = new Image();
        img.src = reader.result;

        img.onload = function() {
            const validWidth = 420;
            const validHeight = 250;
            const validSIze = 450;
            if (img.width !== validWidth || img.height !== validHeight) {
                updateImg.value='';
                validateElement.innerHTML = "Image dimension are within limits 420x250";
                parentElm.appendChild(validateElement);
            } else if(validSIze <= fileSize) {
                updateImg.value='';
                validateElement.innerHTML = "Image size are within limits 450kb";
                parentElm.appendChild(validateElement);
            }
            setTimeout(function () {
                if($(parentElm).find(validateElement)){
                    $(validateElement).remove();
                }
            }, 5000);
        };
    };
    reader.readAsDataURL(file);
}


function newsUpdate(updateNws) {
    var updateRes = updateNws;
    let parentList = updateRes.parentNode.parentNode.parentNode.parentNode;
    let editView = updateRes.parentNode.parentNode.parentNode;
    let parentElement = updateRes.parentNode.parentNode;
    let newsTitle = parentList.querySelector('strong');
    let newsContent = parentList.querySelector('p');
    let newsImage = parentList.querySelector('img');
    let newTitle = parentElement.querySelector('.update-news-title');
    let newImage = parentElement.querySelector('.update-news-image');
    let newContent = parentElement.querySelector('.update-news-description');
    // console.log("PP",parentElement);
    // Update News Title
    if(newTitle.value == ''){
        newsTitle.innerText =  newsTitle.innerText;
    }else {
        newsTitle.innerText ='' ;
        newsTitle.innerText = newTitle.value;
    }
    // Update News Content
    if(newContent.value == ''){
        newsContent.innerText =  newsContent.innerText;
    }else {
        newsContent.innerText ='' ;
        newsContent.innerText = newContent.value;
    }
    // IMAGE
    if(newImage.files[0]){
        var file = newImage.files[0];
        var reader = new FileReader();
        reader.onload = function() {
            var base64String = reader.result.split(",")[1];
            newsImage.src= 'data:image/png;base64,'+base64String;
        };
        reader.readAsDataURL(file);
    }
    $(editView).slideToggle();
    $(parentList).find('.news-edit').show();
    $(".ctrl-btn").css('pointer-events','visible');
    $(".ctrl-btn").css('opacity','1');
}
function populateAlerts(b) {

    let alertDiv = document.getElementById("alert-menu");
    if (b.length == 0) {

    } else {
        alertDiv.innerHTML = "";
        for (let i = (b.length - 1); i >= 0; i--) {
            let alertList = document.createElement('li');
            alertList.className = "drag-list";
            alertList.innerHTML = '<div class="input-row">' +
                '<input type="text" class="input-ctrl" value="' + b[i].alert + '">' +
                '</div>' + '<span class="list-ctrl">' +
                '<button class="edit-list"></button>' +
                '<button class="save-list"></button>' +
                '<button class="delete-list"></button>' +
                '</span>' +
                '</li>'

            alertDiv.prepend(alertList);

            $('.delete-list').click(function (e) {
                e.preventDefault();
                $(this).parent().parent('.drag-list').remove();
            });

        }
    }
}


function populateBanner(a) {

// console.log("a data",a);
    let imgPreview = document.getElementById('img-preview')

    if (a.length == 0) {

    } else {

        for (let i = 0; i <= a.length - 1; i++) {
            wrapper = document.createElement('div');
            wrapper.classList.add('banner-list');
            wrapper.id = "bannerHomeimg" + i;
            removeBtn = document.createElement("span");
            removeBtn.classList.add('remove-btn');
            let img = document.createElement('img');
            img.src = a[i].image;
            img.classList.add('img-preview-thumb');

            var inputImg = document.createElement('input');
            inputImg.classList.add('input-ctrl');
            inputImg.value = a[i].image;
            inputImg.classList.add('d-none');
            inputImg.style.display = 'none'

            var inputBanurl = document.createElement('input');
            inputBanurl.classList.add('input-ctrl');
            inputBanurl.value = a[i].url;
            inputBanurl.style.pointerEvents='none';
            // inputBanurl.classList.add('d-none');

            wrapper.appendChild(img);
            wrapper.appendChild(inputBanurl);
            wrapper.appendChild(inputImg);
            wrapper.appendChild(removeBtn);
            imgPreview.prepend(wrapper);
        }
    }

}



function songUpload() {
  //  var audio=document.getElementById("song");
   var audioMoveable=document.getElementById("audioSong");
    var file = $("#song")[0];
    var reader = new window.FileReader();
    reader.readAsDataURL(file.files[0]);

    reader.onloadend = function () {
        base64 = reader.result;
        base64 = base64.split(',')[1];
        var song=  'data:audio/mp3;base64,'+base64
        console.log(song);



        audioMoveable.src=song;
        //audioMoveable.prepend(audio);
    }
}

function populateSong(dbSong) {

    var audioMoveable=document.getElementById("audioMoveable");



    audioMoveable.innerHTML=' <audio id="audioSong" controls src="' + dbSong + '">' +
        '</audio>'
}


function fetchVideoBanner(v) {
     // console.log("result.videos.data", v);
    let videoPreview = document.getElementById('video-preview')
        for (let i = 1; i <= v.length - 1; i++) {
            wrapperVideo = document.createElement('div');
            wrapperVideo.classList.add('video-col');
            wrapperVideo.id = "banvid" + i;
            removeBtnvideo = document.createElement("span");
            removeBtnvideo.classList.add('remove-btn');

            var img_1 = document.createElement('img');
          // imag1.className='input-ctrl';
            img_1.className='video-ctrl';
            img_1.src = v[i].thumbnail;
            img_1.classList.add('img-preview-thumb');
            img_1.classList.add('img-ctrl');


            var inputVideo = document.createElement('input');
            inputVideo.classList.add('input-ctrl')
            inputVideo.value = v[i].thumbnail;
            inputVideo.classList.add('d-none');
            inputVideo.style.display = 'none'

            var inputVideourl = document.createElement('input');
            inputVideourl.classList.add('input-ctrl');
            inputVideourl.classList.add('video-ctrl');
            inputVideourl.value = v[i].url;
          // inputVideourl.style.pointerEvents='none';


            var inputTitle = document.createElement('input');
            inputTitle.classList.add('input-ctrl');
            inputTitle.classList.add('video-ctrl');

            inputTitle.value = v[i].title;
          // inputTitle.style.pointerEvents='none';
            inputTitle.classList.add('d-none');

            wrapperVideo.appendChild(img_1);
            wrapperVideo.appendChild(inputVideourl);
            wrapperVideo.appendChild(inputVideo);
            wrapperVideo.appendChild(inputTitle);
            wrapperVideo.appendChild(removeBtnvideo);
            videoPreview.prepend(wrapperVideo);
        }
}


$(function () {
    $('.add-banner-image').click(function () {
        $('.add-banner-modal').toggleClass('open');
    });
    $('.add-ceo-banner, .ceo-edit, .close-ceo-modal').click(function () {
        $('.add-md-video-modal').toggleClass('open');
    });
    $('.close-image-bnr').click(function () {
        $('.add-banner-modal').toggleClass('open');
    });

    if ($('.input-row .validate-text').length > 0) {
        $('.validate-text').remove();
    }
    
    var span = document.createElement("span");
    span.className = "validate-text";
    var span_1=document.createElement("span")
    span_1.className = "validate-text";
// ////////////////////home video

    $("#upload").bind("click", function () {
        // Get reference of FileUpload.
        var fileUpload = $("#fileUpload")[0];


        var reader = new FileReader();
        // Read the contents of Image File.
        reader.readAsDataURL(fileUpload.files[0]);
        reader.onload = function (e) {

            // Initiate the JavaScript Image object.
            var image = new Image();
            // Set the Base64 string return from FileReader as source.
            image.src = e.target.result;
            image.onload = function () {
                // Determine the Height and Width.
            	var height = this.height;
            	var width = this.width;
            	var videoBannerUrl = document.getElementById("banner-video-url").value;
            	let banVidSize=document.getElementById("fileUpload");
            	let size=(banVidSize.files.item(0).size)/1024;
            	// console.log("size",size)
            	var titleBannerUrl = document.getElementById("bannerVideoTitle").value;
            	var videoBannerUrl = document.getElementById("banner-video-url").value;

            	if ((height != 250 || width != 420) || size>450 ||titleBannerUrl.length==0 ||  videoBannerUrl.length==0 ) {
            	    if(height != 250 || width != 420 || size>450 ) {
            	        let main = document.getElementById("videoBanErr");
            	        span.innerHTML = "Video size and Resolution should be 420px X 250px and 450 kb ";
            	        main.appendChild(span);
            	    }
            	    else if(titleBannerUrl.length==0 && videoBannerUrl.length==0){
            	            let main = document.getElementById("videoBanTitle");
            	            let main_1 = document.getElementById("videoBanUrlErr");
            	            span_1.innerHTML="not to be Blank ";
            	            span.innerHTML = "not to be Blank ";
            	            main.appendChild(span_1);
            	            main_1.appendChild(span);
            	        }
            	else if(titleBannerUrl.length==0){
            	        let main = document.getElementById("videoBanTitle");
            	        span.innerHTML = "not to be Blank ";
            	        main.appendChild(span);
            	    }
            	    else if(videoBannerUrl.length==0){
            	        let main = document.getElementById("videoBanUrlErr");
            	        span.innerHTML = "not to be Blank ";
            	        main.appendChild(span);
            	    }
            	}

                else {
                        videoPreview = document.getElementById('video-preview')
                        wrapperVideo = document.createElement('div');
                        wrapperVideo.classList.add('video-col');
                        removeBtnvideo = document.createElement("span");
                        removeBtnvideo.classList.add('remove-btn');
                        img = document.createElement('img');
                        img.src = e.target.result;
                        img.classList.add('img-preview-thumb');
                        img.classList.add('img-ctrl');
                        img.classList.add('video-ctrl');

                        var inputVideo = document.createElement('input');
                       // inputVideo.classList.add('input-ctrl');
                        inputVideo.classList.add('d-none');
                        inputVideo.value = e.target.result;
                        inputVideo.style.display = 'none'

                        var inputVideourl = document.createElement('input');
                        inputVideourl.classList.add('input-ctrl');
                        inputVideourl.classList.add('video-ctrl');

                        var videoBannerUrl = document.getElementById("banner-video-url").value;
                        inputVideourl.value = videoBannerUrl;
                        inputVideourl.style.pointerEvents='none';
                        // inputVideourl.classList.add('d-none');

                        var inputTitle = document.createElement('input');
                        inputTitle.classList.add('input-ctrl');
                        inputTitle.classList.add('video-ctrl');
                        var titleBannerUrl = document.getElementById("bannerVideoTitle").value;
                        inputTitle.value = titleBannerUrl;
                       inputTitle.style.pointerEvents='none';
                        inputTitle.classList.add('d-none');

                        wrapperVideo.appendChild(img);
                        wrapperVideo.appendChild(inputVideourl);
                        wrapperVideo.appendChild(inputVideo);
                        wrapperVideo.appendChild(inputTitle);
                        wrapperVideo.appendChild(removeBtnvideo);
                        videoPreview.prepend(wrapperVideo);

                        $('.add-video-modal').removeClass('open');
                    }
                document.getElementById("banner-video-url").value = '';
                document.getElementById("fileUpload").value = '';
                document.getElementById("bannerVideoTitle").value = '';
              
                }
                ;
            }
        $('.validate-text').remove();
    });













// ////////////////////home banner image


    $("#upload-img").bind("click", function () {
        // Get reference of FileUpload.
        var fileUpload1 = $("#fileUpload-img")[0];

        var reader = new FileReader();
        // Read the contents of Image File.
        reader.readAsDataURL(fileUpload1.files[0]);
        reader.onload = function (e) {
            // Initiate the JavaScript Image object.
            var image = new Image();
            // Set the Base64 string return from FileReader as source.
            image.src = e.target.result;
            image.onload = function () {
                // Determine the Height and Width.
                var height = this.height;
                var width = this.width;
                // console.log("height,width",height);
                let banImgSize=document.getElementById("fileUpload-img");
                let size_1=(banImgSize.files.item(0).size)/1024;

                var BanVideoUrl = document.getElementById("banner-url").value;
                  if ((height != 320 || width != 820) || size_1>450 ||BanVideoUrl.length==0 ) {
                    if ((height != 320 || width != 820) || size_1>450) {
                        var main = document.getElementById("bannerImgErr");
                        span.innerHTML = "Image size resolution  should be 820px X 320px and 450kb.";
                        main.appendChild(span);
                    }
                    else if(BanVideoUrl.length==0){
                        let main = document.getElementById("bannerUrlErr");
                        span.innerHTML = "not to be Blank ";
                        main.appendChild(span);
                    }
                
                } else {
                    imgPreview = document.getElementById('img-preview')
                    wrapper = document.createElement('div');
                    wrapper.classList.add('banner-list');
                    removeBtn = document.createElement("span");
                    removeBtn.classList.add('remove-btn');
                    img = document.createElement('img');
                    img.src = e.target.result;
                    img.classList.add('img-preview-thumb');
                    var inputImg = document.createElement('input');
                    inputImg.classList.add('input-ctrl');
                    inputImg.classList.add('banner-url');
                    inputImg.value = e.target.result;
                    inputImg.classList.add('d-none');
                    inputImg.style.display = 'none'

                    var inputBanurl = document.createElement('input');
                    inputBanurl.classList.add('input-ctrl');
                    var BanVideoUrl = document.getElementById("banner-url").value;
                    inputBanurl.value = BanVideoUrl;
                    inputBanurl.style.pointerEvents='none';
                    // inputBanurl.classList.add('d-none');

                    wrapper.appendChild(img);
                    wrapper.appendChild(inputBanurl);
                    wrapper.appendChild(inputImg);
                    wrapper.appendChild(removeBtn);
                    imgPreview.prepend(wrapper);
                    $('.add-banner-modal').removeClass('open');
                    $('.input-file').val('');
                    $('.validate-text').remove();
                }
                document.getElementById("banner-url").value = '';
                document.getElementById("fileUpload-img").value = '';
                return true;
            }
            ;
        }

    });

    $("#md-modal-submit").bind("click", function () {
        // Get reference of FileUpload.
            var fileUpload = $("#md-video-banner")[0];

            var reader_3 = new FileReader();
            // Read the contents of Image File.
            reader_3.readAsDataURL(fileUpload.files[0]);
            reader_3.onload = function (e) {
            // Initiate the JavaScript Image object.
            var image = new Image();
            // Set the Base64 string return from FileReader as source.
            image.src = e.target.result;

            image.onload = function () {
                // Determine the Height and Width.
                var height = this.height;
                var width = this.width;
                var mdUrl = document.getElementById("md-video-url").value;
                let banImgSize=document.getElementById("fileUpload-img");
                let size_2=(banImgSize.files.size)/1024;
                if ( (height != 250 || width != 420)|| size_2>450|| mdUrl.length==0) {
                    if(height != 250 || width != 420|| size_2>450){
                    var main = document.getElementById("bannerCeoErr");
                    span.innerHTML = " Size and resolution should be 420X 250 and 450 kb ";
                    main.appendChild(span);
                } else if(mdUrl.length==0){
                    let main = document.getElementById("bannerCeoUrlErr");
                    span.innerHTML = "not to be Blank ";
                    main.appendChild(span);
                }

                    return false;
                }
                 else {
                    let mdPreviewImg = document.getElementById("video-banner-Img");
                    let mdVidBnr = document.getElementById("md-vid-banner");
                    let mdPreviewUrl = document.getElementById("video-banner-url");


                    mdPreviewImg.value = image.src;
                    mdVidBnr.src = image.src;
                    mdPreviewUrl.value = mdUrl;
                    mdPreviewUrl.style.pointerEvents='none';
                    $('.add-md-video-modal.open').removeClass('open');
                    $('#video-banner-input').hide();
                    $('#ceo-preview').show();
                   /*
					 * let obj = { "title": "Message from MD & CEO",
					 * "thumbnail": mdVidBnr.src, "url": mdPreviewUrl.value };
					 */
                  // video_data.splice(0, 0, obj);

                }
                document.getElementById("md-video-url").value='';
                document.getElementById("md-video-banner").value=''
                $('.validate-text').remove();
                return true;

            };
        }
    });
});
$(document).on('click', '.remove-btn', function () {
    $(this).parent('.banner-list').remove();
    $(this).parent('.video-col').remove();
});
$(document).ready(function () {
    $('.input-ctrl',).keyup(function () {
        $(this).siblings('.validate-text').remove();
    });
});

function populateCeo(g) {
    // console.log("g data",g);
    if (g.length == 0) {

    } else {


        let mdPreviewImg = document.getElementById("video-banner-Img");
        let mdVidBnr = document.getElementById("md-vid-banner");
        let mdPreviewUrl = document.getElementById("video-banner-url");
        // var mdUrl= document.getElementById("md-video-url").value;
        // mdPreviewImg.value= image.src;
        mdVidBnr.src = g[0].thumbnail;
        mdPreviewUrl.value = g[0].url;
        mdPreviewUrl.style.pointerEvents='none';
        $('.add-md-video-modal.open').removeClass('open');
        $('#video-banner-input').hide();
        $('#ceo-preview').show();


    }
}

var video_data = [];


const home_publish = document.getElementById("home_preview");

home_publish.addEventListener('click', function (event) {
    $('.page-container').addClass('loading');
    home_publish.classList.add('loading');
    var side_data = [];
    let homeSideMenu = {};

    // Get all input elements on the sidemenu
    const sidemenu = document.querySelector('#homeMenu');
    const sidevalues = sidemenu.querySelectorAll('.input-ctrl');

    // Loop through each input element and get its value

    for (let i = 0; i < (sidevalues.length) - 1; i++) {

        if (i % 2 == 0) {

            const text = sidevalues[i];
            const url = sidevalues[i + 1];

            const text_value = text.value;
            const url_value = url.value;

            let obj =
                {
                    "text": text_value,
                    "url": url_value
                };

            side_data.unshift(obj);

        }

    }

   /*
	 * homeSideMenu = { "data": side_data }
	 */

    // console.log("input values" + JSON.stringify(homeSideMenu));


    var alerts_data = [];

    // Get all input elements on the alerts
    const alertmenu = document.querySelector('#alert-menu');
    const alertvalues = alertmenu.querySelectorAll('.input-ctrl');

    // Loop through each input element and get its value

    for (let i = 0; i < alertvalues.length; i++) {

        const text = alertvalues[i];

        const text_value = text.value;

        let obj =
            {
                "alert": text_value,
            };

        alerts_data.unshift(obj);
    }


    // console.log("alerts input values" + JSON.stringify(alerts_data));

    var blurb_data = [];

    // Get all input elements on the blurbs
    const blurbmenu = document.querySelector('#home_blurbs');
    const blurbvalues = blurbmenu.querySelectorAll('.input_values');


    // Loop through each input element and get its value

    for (let i = 0; i < (blurbvalues.length) - 1; i++) {

        if (i % 2 == 0) {

            const image = blurbvalues[i];
            const url = blurbvalues[i + 1];


            const thumbnail_value = image.src;
            const url_value = url.value;

            let obj =
                {
                    "thumbnail": thumbnail_value,
                    "url": url_value
                };

            blurb_data.unshift(obj);

        }

    }

    var news_data = [];
    let homeNewsMenu = {};

    // Get all input elements on the news
    const newsmenu = document.querySelector('#news-fetchList');
    const newsvalues = newsmenu.querySelectorAll('.news-data');


    // Loop through each input element and get its value

    for (let i = 0; i < (newsvalues.length) - 2; i++) {

        if (i % 3 == 0) {

            const image = newsvalues[i];
            const title = newsvalues[i + 1];
            const text = newsvalues[i + 2];


            const image_value = image.src;
            const title_value = title.innerHTML;
            const text_value = text.innerHTML;

            let obj =
                {
                    "image": image_value,
                    "date": "",
                    "location": "",
                    "time": "",
                    "title": title_value,
                    "text": text_value
                };


            news_data.unshift(obj);

        }

    }

    homeNewsMenu = {
        "title": "News And Events",
        "data": news_data
    }

    // console.log("input values homeNewsMenu" + JSON.stringify(homeNewsMenu));


    var banner_data = [];


    const bannerMenu = document.querySelector('#img-preview');
    const bannerValues = bannerMenu.querySelectorAll('.input-ctrl');

    for (let i = 0; i < (bannerValues.length) - 1; i++) {

        if (i % 2 == 0) {

            const image = bannerValues[i];
            const url = bannerValues[i + 1];

            const image_value = image.value;
            const url_value = url.value;


            let obj =
                {
                    "image": url_value,
                    "url": image_value,

                }


            banner_data.unshift(obj);

        }
    }

    const mdUrl = document.getElementById("video-banner-url");
    const ceoImage=document.getElementById("md-vid-banner").src;

    let ceobj =
        {
            "title": "Message from MD & CEO",
            "thumbnail": ceoImage,
            "url": mdUrl.value
        }

    video_data.splice(0, 0, ceobj);

    const videoMenu = document.querySelector('#video-preview');
    const videoValues = videoMenu.querySelectorAll('.video-ctrl');

    for (let i = 0; i < (videoValues.length) - 1; i++) {

        if (i % 3 == 0) {

            const title = videoValues[i + 2];
            const url = videoValues[i + 1];
            const thumbnail= videoValues[i];

            const title_value = title.value;
            const thumbnail_value = thumbnail.src;
            const url_value = url.value;

            let obj =
                {
                    "title": title_value,
                    "thumbnail": thumbnail_value,
                    "url": url_value
                }


             video_data.splice(1, 0, obj);

        }

    }
    // console.log("video_data", video_data)


    // var mesc_data = [];
    // var mescVale = {};
    //
    //
    // // Get all input elements on the miscellaneous
    // const miscellaneousmenu = document.querySelector('#miscelleneous_list');
    // const miscellaneousvalues =
	// miscellaneousmenu.querySelectorAll('.miss_values');
    //
    //
    // // Loop through each input element and get its value
    //
    // for (let i = 0; i < (miscellaneousvalues.length); i++) {
    //
    // if (i % 4 == 0) {
    //
    // const color = miscellaneousvalues[i];
    // const image = miscellaneousvalues[i + 1];
    // const content = miscellaneousvalues[i + 2];
    // const url = miscellaneousvalues[i + 3];
    //
    //
    // const color_value = color.value;
    // const img_value = image.src;
    // const text_value = content.value;
    // const url_value = url.value;
    //
    //
    // let obj =
    // {
    // "content": text_value,
    // "image": img_value,
    // "url": url_value,
    // "color": color_value,
    // }
    //
    //
    // mesc_data.unshift(obj);
    //
    //
    // }
    //
    // }
    //
    // mescVale = {
    // "data": mesc_data
    // }
    //
    //
    // //console.log("input values mesc_data" + JSON.stringify(mescVale));
    // //console.log("mesc_data", mesc_data);

    var emp_data = [];

    // Get all input elements on the alerts
    const empmenu = document.querySelector('#emp-menu');
    const empvalues = empmenu.querySelectorAll('.input-ctrl');

    // Loop through each input element and get its value

    // for (let i = 0; i < empvalues.length; i++) {

        const text = empvalues[0];

        const emp_value = text.value;

        // let obj =
        // {
        // "employeeSearch": emp_value,
        // };
        //
        // emp_data.unshift(obj);
        //
        // //console.log("employee",emp_data)
 // }

    // console.log("employee input values" + JSON.stringify(emp_data));
    var sectionData = [];
    var menu = [];
    let footerMenu = {};

    // Get all input elements on the news
    const footer = document.querySelector('#group-row');
    // const footerValues = footer.querySelectorAll('.menu-group');
    //
    //
    // for (let i = 0; i < footerValues.length; i++) {
    //
    // menu = [];
    // const footerheadingValue =
	// document.querySelectorAll('.menu-title').item(i).value;
    // const testingValue =
	// document.querySelectorAll('.group-body').item(i).childNodes;
    //
    // for (let k = 0; k < testingValue.length; k++) {
    // //
    // // if(k%2==0) {
    // const text = testingValue[k].childNodes[2].childNodes[1].value;
    // const url = testingValue[k].childNodes[2].childNodes[3].value;
    //
    // var obj = {
    //
    // "text": text,
    // "url": url
    //
    // }
    // menu.unshift(obj);
    // //}
    // }
    //
    // var main_obj = {
    // "title": footerheadingValue,
    // "menu": menu
    // }
    //
    // sectionData.unshift(main_obj);
    // }

    const groupRow = footer;
    const groupList = groupRow.querySelectorAll('.menu-group');

    for(let i=0; i<groupList.length; i++){
        menu = [];
        let groupTitle = groupList[i].querySelector('.menu-title').value;
        let groupBody = groupList[i].querySelector('.group-body');
        let menuList = groupBody.querySelectorAll('.menu-list');
        for(let j=0; j<menuList.length; j++){
            let menuRow = menuList[j].querySelector('.menu-row');
            let menuLabel = menuRow.querySelector('.menu-label').value;
            let menuUrl = menuRow.querySelector('.menu-url').value;

            var obj = {
                "text": menuLabel,
                "url": menuUrl
            }
            menu.unshift(obj);
        }
        var main_obj = {
            "title": groupTitle,
            "menu": menu
        }
        sectionData.unshift(main_obj);
    }


var audioText=document.getElementById("audioSong").src;

    // //console.log("input values footer_data" + JSON.stringify(sectionData));

    var post_data = JSON.stringify({
        "sideMenu": {
            "data": side_data
        },
        "images": {
            "data": banner_data

        },
        "blurb": {
            "data": blurb_data,
        },
        "alerts": {
            "alerts": alerts_data
        },
        "videos": {
            "data": video_data
        }, "newsAndEvents": {
            "title": "News And Events",
            "data": news_data,
        },
        // "miscellaneous": {
        // "data": mesc_data,
        // },
        "employeeSearch": {
            "url":emp_value
        },
        "footer": {
            "sectionData": sectionData
        },
        "music":{
            "audioText":audioText
        }
    });


    console.log(post_data);
    postApi("./api/homePublish", post_data, function (response,status) {

        // console.log("this ",response);
        const tostRow = document.querySelector('#publish-success');
        if(status == 200){
            let tostContent = document.createElement('p');
            tostContent.innerHTML="Home page published Successfully";
            tostRow.classList.add('open');
            tostRow.classList.add('success');
            tostRow.append(tostContent);
        }else {
            let tostContent = document.createElement('p');
            tostContent.innerHTML="Home page published Failed";
            tostRow.classList.add('open');
            tostRow.classList.add('failed');
            tostRow.append(tostContent);
        }
        setTimeout(function () {
            home_publish.classList.remove('loading');
            $('.tost-top').removeClass('open');
            $('.tost-top').find('p').remove();
            $('.page-container').removeClass('loading')
            window.location.reload();
        }, 2000);
    });

});

function postApi(url, reqBody, callback) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            callback(this.responseText,this.status);
        }
    }

    xhr.open('POST', url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(reqBody);
}