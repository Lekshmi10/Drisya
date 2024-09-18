<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/fonts/stylesheet.css">
    <link rel="stylesheet" href="./resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="./resources/css/style.css">
    <title>Drisya | Dashboard</title>
</head>
<body>
<div class="template-widget">
    <div class="template-body">
        <div class="template-sidebar">
            <div class="logo-widget">
                <a href="#" class="logo">
                    <img class="logo-1" src="./resources/images/logo.png" alt="">
                    <img class="logo-2" src="./resources/images/logo-icon.png" alt="">
                </a>
                <button class="toggle-sm">
                    <svg width="23" height="16.45" viewBox="0 0 23 16.45">
                        <g transform="translate(-400 -942.55)">
                            <path class="def"
                                  d="M21,18v2H3V18ZM6.95,3.55v9.9L2,8.5,6.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z"
                                  transform="translate(402 939)" fill="#707070"/>
                            <path class="hov"
                                  d="M21,18v2H3V18ZM2.95,3.55v9.9L-2,8.5,2.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z"
                                  transform="translate(402 939)" fill="#707070"/>
                        </g>
                    </svg>
                </button>
            </div>
            <nav class="sidebar-navigation">
                <ul>
                    <li>
                        <a href="./home" class="active">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path
                                            d="M80 212v236a16 16 0 0016 16h96V328a24 24 0 0124-24h80a24 24 0 0124 24v136h96a16 16 0 0016-16V212"
                                            fill="none" stroke="currentColor" stroke-linecap="round"
                                            stroke-linejoin="round" stroke-width="32"></path><path
                                            d="M480 256L266.89 52c-5-5.28-16.69-5.34-21.78 0L32 256M400 179V64h-48v69"
                                            fill="none" stroke="currentColor" stroke-linecap="round"
                                            stroke-linejoin="round" stroke-width="32"></path></svg>
                                </span>
                            <span class="nav-text">Home Page</span>
                        </a>
                    </li>
                    <li>
                        <a href="./applications">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path
                                            d="M440 432H72a40 40 0 01-40-40V120a40 40 0 0140-40h75.89a40 40 0 0122.19 6.72l27.84 18.56a40 40 0 0022.19 6.72H440a40 40 0 0140 40v240a40 40 0 01-40 40zM32 192h448"
                                            fill="none" stroke="currentColor" stroke-linecap="round"
                                            stroke-linejoin="round" stroke-width="32"></path></svg>
                                </span>
                            <span class="nav-text">Applications Page</span>
                        </a>
                    </li>
                    <li>
                        <a href="./reference">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path
                                            d="M402 168c-2.93 40.67-33.1 72-66 72s-63.12-31.32-66-72c-3-42.31 26.37-72 66-72s69 30.46 66 72z"
                                            fill="none" stroke="currentColor" stroke-linecap="round"
                                            stroke-linejoin="round" stroke-width="32"></path><path
                                            d="M336 304c-65.17 0-127.84 32.37-143.54 95.41-2.08 8.34 3.15 16.59 11.72 16.59h263.65c8.57 0 13.77-8.25 11.72-16.59C463.85 335.36 401.18 304 336 304z"
                                            fill="none" stroke="currentColor" stroke-miterlimit="10"
                                            stroke-width="32"></path><path
                                            d="M200 185.94c-2.34 32.48-26.72 58.06-53 58.06s-50.7-25.57-53-58.06C91.61 152.15 115.34 128 147 128s55.39 24.77 53 57.94z"
                                            fill="none" stroke="currentColor" stroke-linecap="round"
                                            stroke-linejoin="round" stroke-width="32"></path><path
                                            d="M206 306c-18.05-8.27-37.93-11.45-59-11.45-52 0-102.1 25.85-114.65 76.2-1.65 6.66 2.53 13.25 9.37 13.25H154"
                                            fill="none" stroke="currentColor" stroke-linecap="round"
                                            stroke-miterlimit="10" stroke-width="32"></path></svg>
                                </span>
                            <span class="nav-text">Reference Pages</span>
                        </a>
                    </li>
                    <li>
                        <a href="./support">
                            <span class="icon">
                                <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path
                                        d="M160 164s1.44-33 33.54-59.46C212.6 88.83 235.49 84.28 256 84c18.73-.23 35.47 2.94 45.48 7.82C318.59 100.2 352 120.6 352 164c0 45.67-29.18 66.37-62.35 89.18S248 298.36 248 324"
                                        fill="none" stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10"
                                        stroke-width="40"/><circle cx="248" cy="399.99" r="32"/></svg>
                            </span>
                            <span class="nav-text">Support Page</span>
                        </a>
                    </li>
                    <li>
                        <a href="./retirement" id="retirement_data">
                            <span class="icon">
                                <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path
                                        d="M416 221.25V416a48 48 0 01-48 48H144a48 48 0 01-48-48V96a48 48 0 0148-48h98.75a32 32 0 0122.62 9.37l141.26 141.26a32 32 0 019.37 22.62z"
                                        fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="32"/><path
                                        d="M256 56v120a32 32 0 0032 32h120" fill="none" stroke="currentColor"
                                        stroke-linecap="round" stroke-linejoin="round" stroke-width="32"/></svg>
                            </span>
                            <span class="nav-text">Retirement</span>
                        </a>
                    </li>
                     <li>
                        <a href="./retirementActivation">
                            <span class="icon">
                                <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path
                                        d="M416 221.25V416a48 48 0 01-48 48H144a48 48 0 01-48-48V96a48 48 0 0148-48h98.75a32 32 0 0122.62 9.37l141.26 141.26a32 32 0 019.37 22.62z"
                                        fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="32"/><path
                                        d="M256 56v120a32 32 0 0032 32h120" fill="none" stroke="currentColor"
                                        stroke-linecap="round" stroke-linejoin="round" stroke-width="32"/></svg>
                            </span>
                            <span class="nav-text">Retirement Activation</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="template-container">
            <div class="template-header">
                <button class="toggle-button">
                    <svg width="23" height="16.45" viewBox="0 0 23 16.45">
                        <g transform="translate(-400 -942.55)">
                            <path class="def"
                                  d="M21,18v2H3V18ZM6.95,3.55v9.9L2,8.5,6.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z"
                                  transform="translate(402 939)" fill="#707070"/>
                            <path class="hov"
                                  d="M21,18v2H3V18ZM2.95,3.55v9.9L-2,8.5,2.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z"
                                  transform="translate(402 939)" fill="#707070"/>
                        </g>
                    </svg>
                </button>
                <div class="template-ctrl">
                    <button class="ctrl-btn" id="home_preview" style="opacity: 0.5;pointer-events: none">Save & Publish</button>
                </div>
                <div class="user-control">
                    <div class="user-head"><!--open-->
                        <img src="./resources/images/avatar-f.jpg" alt=""  onclick="signOut()">
                        <div class="user-name"><% out.print(session.getAttribute("uname")); %></div>
                        <input class="user-role" id="user-role" value="<% out.print(session.getAttribute("role")); %>"  style="display:none"></input>
                    </div>
                </div>
            </div>
            <div Id="signout" style="display:none;">
                <a href="./signout" class="signout-div">Signout</a>
            </div>
            <div class="nav-widget-primary">
                <ul>
                    <li><a href="#" class="nav-menu-list active" data-menu="dashboard">Dashboard</a></li>
                    <li><a href="#" class="nav-menu-list" data-menu="side-menu">Side Menu</a></li>
                    <li><a href="#" class="nav-menu-list" data-menu="news-event">News & Events</a></li>
                    <li><a href="#" class="nav-menu-list" data-menu="blurbs">Blurbs</a></li>
                    <li><a href="#" class="nav-menu-list" data-menu="footer">Footer</a></li>
                    <li><a href="#" class="nav-menu-list" data-menu="Alerts">Alerts</a></li>
                    <li><a href="#" class="nav-menu-list" data-menu="Employee-search">Employee-Search</a></li>
                    <li><a href="#" class="nav-menu-list" data-menu="Audio">Audio</a></li>
<%--                    <li><a href="#" class="nav-menu-list" data-menu="Miscellaneous">Miscellaneous</a></li>--%>
                </ul>
            </div>
            <div class="page-container tab-body-homepage active" id="dashboard">
                <div class="template-card mb-15">
                    <div class="banner-container">
                        <div class="add-banner-row">
                            <div class="banner-title mb-15">
                                <h3>Banner images</h3>
                                <hr>
                            </div>
                            <div class="banner-view" id="img-preview">
                                <div class="banner-list add-new-bnr">
                                    <img src="./resources/images/image-upload.png">
                                    <span>Add Image</span>
                                    <div class="add-banner-btn add-banner-image">
                                        Add Image
                                        <%--                                        <input type="file" class="add-banner-input" name="images[]"  id="upload-img" onchange="addImage(this)">--%>
                                    </div>
                                    <p>Recommended sizes 820px X 320px and 450kb</p>
                                </div>
                            </div>
                        </div>
                        <div class="ceo-banner">
                            <div class="add-banner-form">
                                <h3>Message from MD & CEO</h3>
                                <div class="add-ceo-video">
                                    <div class="add-video-bnr" id="video-banner-input">
                                        <img src="./resources/images/video-upload.png">
                                        <span>Video banner</span>
                                        <div class="add-btn add-ceo-banner">Add Banner Image</div>
                                        <p>Recommended sizes 420px X 250px and 450kb</p>
                                        <input type="text" class="input-ctrl d-none" id="video-banner-Img">
                                    </div>
                                    <div class="ceo-preview d-none" id="ceo-preview">
                                        <button class="ceo-edit"><i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <div class="video-banner">
                                            <img id="md-vid-banner" class="w-100">
                                        </div>
                                        <div class="input-row">
                                            <label for="" class="input-label">Video Url</label>
                                            <input type="text" class="input-ctrl" placeholder="Video Url"
                                                   id="video-banner-url">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="template-card">
                    <div class="banner-title mb-15">
                        <h3>Videos</h3>
                        <hr>
                    </div>
                    <div class="video-list" id="video-preview"></div>
                    <div class="video-widget">
                        <img src="./resources/images/video-upload.png">
                        <span>Add Video</span>
                        <button class="add-video-btn">Add Video</button>
                       <p>Recommended sizes 420px X 250px and 450kb</p>
                    </div>
                </div>
            </div>
            <div class="page-container tab-body-homepage" id="side-menu">
                <div class="template-card">
                    <h3>Side Menu</h3>
                    <hr>
                    <div class="menu-container">
                        <div class="menu-widget">
                            <ul id="homeMenu" class="moveable drag-menu-row"></ul>
                        </div>
                        <div class="add-menu-widget">
                            <div class="add-menu-form">
                                <h3>Create menu</h3>
                                <hr class="mb-18">
                                <div class="input-row" id="home_title">
                                    <input type="text" class="input-ctrl" id="homeSide-title" placeholder="Enter Text">
                                </div>
                                <div class="input-row" id="home_url">
                                    <input type="text" class="input-ctrl" id="homeSide-url" placeholder="Enter Url">
                                </div>
                                <button class="add-menu" id="homeSideMenu" onclick="addHomeMenu(this.id)">Add Menu
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="page-container tab-body-homepage" id="news-event">
                <div class="template-card">
                    <div class="card-title">
                        <h3>News & Events</h3>
                        <div class="btn-row">
                            <button class="add-btn open-news-form">Add New</button>
                        </div>
                    </div>
                    <hr>
                    <div class="news-eventform-widget" id="news-event-modal">
                        <div class="form-card add-news-event">
                            <div class="input-row news-event-list" id="homeNewsTitle">
                                <label for="" class="input-label">Title</label>
                                <input type="text" class="input-ctrl" placeholder="Enter Title" id="news-title">
                            </div>
                            <div class="input-row news-event-list" id="homeNewsImage">
                                <label for="" class="input-label">Image</label>
                                <input type="file" class="input-file" id="news-image">
                                <p class="input-info">Image dimension & resolution are within limited 420px X 250px and 450kb</p>
                            </div>
                            <div class="input-row news-event-list span-2" id="homeNewsDescription">
                                <label for="" class="input-label">Description</label>
                                <textarea class="text-ctrl input-ctrl" placeholder="Description"
                                          id="news-description"></textarea>
                            </div>
                            <div class="btn-row span-2">
                                <button class="cancel-btn clear-news-form">Cancel</button>
                                <button class="form-submit" id="addNews" onclick="addHomeMenu(this.id)">Submit</button>
                            </div>
                        </div>
                    </div>
                    <div class="news-envent-row" id="news-fetchList"></div>
                </div>
            </div>
            <div class="page-container tab-body-homepage" id="blurbs">
                <div class="template-card">
                    <h3>Blurbs</h3>
                    <hr>
                    <div class="menu-container">
                        <div class="menu-widget">
                            <ul class="moveable drag-menu-row" id="home_blurbs"></ul>
                        </div>
                        <div class="add-menu-widget">
                            <div class="add-menu-form">
                                <h3>Create Blurbs</h3>
                                <hr class="mb-18">
                                <div class="input-row" id="homefile">
                                    <label for="" class="input-label">Image</label>
                                    <input type="file" class="input-file" id="blurbFile">
                                    <p class="input-info">Image dimension & resolution are within limited 350px X 110px and 450kb</p>

                                </div>
                                <div class="input-row" id="homeurl">
                                    <label for="" class="input-label">Url</label>
                                    <input type="text" class="input-ctrl" placeholder="Enter Title Url"
                                           autocomplete="off" id="blurbUrl">
                                </div>
                                <button class="add-menu" onclick="addHomeMenu(this.id)" id="homeBlurbs">Save</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="page-container tab-body-homepage" id="footer">
                <div class="template-card">
                    <div class="card-title">
                        <h3>Footer Menu</h3>
                        <div class="btn-row">
                            <button class="add-btn" id="create-menu">Create Menu</button>
                        </div>
                    </div>
                    <hr>
                    <div class="menu-widget moveable drag-menu-row" id="group-row"></div>
                </div>
            </div>
            <div class="page-container tab-body-homepage" id="Alerts">
                <div class="template-card">
                    <h3>Alerts</h3>
                    <hr>
                    <div class="menu-container">
                        <div class="menu-widget">
                            <ul class="moveable" id="alert-menu">

                            </ul>
                        </div>
                        <div class="add-menu-widget">
                            <div class="add-menu-form">
                                <h3>Create Alerts</h3>
                                <hr class="mb-18">
                                <div class="input-row" id="alert-label">
                                    <label for="" class="input-label">Alerts</label>
                                    <input type="text" class="input-ctrl" id=textAlert placeholder="Enter the alerts"
                                           autocomplete="off">
                                </div>
                                <button class="add-menu" id="addAlerts" onclick="addHomeMenu(this.id)">Save</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="page-container tab-body-homepage" id="Employee-search">
                <div class="template-card">
                    <h3>Employee Search</h3>
                    <hr>
                    <div class="menu-container">
                        <div class="menu-widget">
                            <ul class="moveable" id="emp-menu">

                            </ul>
                        </div>
                        <div class="add-menu-widget">
                            <div class="add-menu-form">
                                <h3>Create Employee Search</h3>
                                <hr class="mb-18">
                                <div class="input-row" id="emp-label">
                                    <label for="" class="input-label">Employee Search</label>
                                    <input type="text" class="input-ctrl" id=textEmp placeholder="Enter the text"
                                           autocomplete="off">
                                </div>
                                <button class="add-menu" id="empSearch" onclick="addHomeMenu(this.id)">Save</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="page-container tab-body-homepage" id="Audio">

                <div class="template-card">
                    <h3>Audio</h3>
                    <hr>
                    <div class="menu-container">
                        <div class="menu-widget">
                            <ul class="moveable" id="audioMoveable"  ></ul>

                            <audio id="audioSong" style="visibility: hidden" controls src="" >
                                </audio >
                        </div>
                        <div class="add-menu-widget">
                            <div class="add-menu-form">
                                <h3>Add Audio</h3>
                                <hr class="mb-18">
                                <div class="input-row music-input" >
                                    <label for="" class="input-label" >Audio</label>
                                    <input type="file" class="input-file"id="song">


                                </div>

                                <button class="add-menu" id="audiofile" onclick="songUpload()" >Save</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<%--            <div class="page-container tab-body-homepage" id="Miscellaneous">--%>
<%--                <div class="template-card">--%>
<%--                    <div class="add-menu-form">--%>
<%--                        <h3>Miscellaneous</h3>--%>
<%--                        <hr>--%>
<%--                        <div class="menu-container">--%>
<%--                            <div class="menu-widget">--%>
<%--                                <ul class="moveable" id="miscelleneous_list"></ul>--%>
<%--                            </div>--%>
<%--                            <div class="add-menu-widget">--%>
<%--                                <div class="add-menu-form">--%>
<%--                                    <h3 class="mb-18">Create Miscellaneous</h3>--%>
<%--                                    <hr class="mb-18">--%>
<%--                                    <div class="input-row" id="missTitle">--%>
<%--                                        <label for="" class="input-label">Title</label>--%>
<%--                                        <input type="text" class="input-ctrl" placeholder="Enter Title"--%>
<%--                                               id="miscelleneous_title" autocomplete="off">--%>
<%--                                    </div>--%>
<%--                                    <div class="input-row">--%>
<%--                                        <label for="" class="input-label">Image</label>--%>
<%--                                        <input type="file" class="input-file" id="miscelleneous_file">--%>
<%--                                    </div>--%>
<%--                                    <div class="input-row" id="missUrl">--%>
<%--                                        <label for="" class="input-label">Url</label>--%>
<%--                                        <input type="text" class="input-ctrl" placeholder="Enter Url"--%>
<%--                                               id="miscelleneous_url">--%>
<%--                                    </div>--%>
<%--                                    <div class="input-row d-flex">--%>
<%--                                        <input type="color" class="input-color mr-10" id="miscelleneous_color">--%>
<%--                                        <label for="miscelleneous_color" class="input-label">Choose Colour</label>--%>
<%--                                    </div>--%>
<%--                                    <button class="add-menu" id="miscelleneous" onclick="addHomeMenu(this.id)">Save--%>
<%--                                    </button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </div>
</div>


<%--BANNER IMAGE UPLOAD--%>
<div class="modal-widget add-banner-modal">
    <div class="modal-container">
        <div class="modal-row">
            <h3>Add Image</h3>
            <hr>
            <div class="input-row" id="bannerImgErr">
                <label for="" class="input-label">Image</label>
                <input type="file" class="input-file" id="fileUpload-img">
                 <p class="input-info">Image dimension & resolution are within limited 820px X 320px and 450kb</p>
            </div>
            <div class="input-row" id="bannerUrlErr">
                <label for="" class="input-label">Url</label>
                <input type="text" class="input-ctrl" id="banner-url" placeholder="Enter Title Url" autocomplete="off">
            </div>

            <div class="btn-row justify-center">
                <button class="cancel-btn close-image-bnr">Cancel</button>
                <input type="button" class="form-submit" id="upload-img" value="Submit">
            </div>
        </div>
    </div>
</div>
<%--VIDEO UPLOAD--%>
<div class="modal-widget add-video-modal">
    <div class="modal-container">
        <div class="modal-row">
            <h3>Add Video </h3>
            <hr>
            <div class="input-row">
                <label for="" class="input-label">Title</label>
                <input type="text" class="input-ctrl" id="bannerVideoTitle" placeholder="Enter Title Url"
                       autocomplete="off">
            </div>
            <div class="input-row" id="videoBanErr">
                <label for="" class="input-label">Video Banner</label>
                <input type="file" class="input-file" id="fileUpload">
                 <p class="input-info">Video dimension & resolution are within limited 420px X 250px and 450kb</p>
                
            </div>
            <div class="input-row" id="videoBanUrlErr">
                <label for="" class="input-label">Url</label>
                <input type="text" class="input-ctrl" id="banner-video-url" placeholder="Enter Title Url"
                       autocomplete="off">
            </div>
            <div class="btn-row justify-center">
                <button class="cancel-btn close-video">Cancel</button>
                <input type="button" class="form-submit" id="upload" value="Submit">
            </div>
        </div>
    </div>
</div>

<%--CEO VIDEO--%>
<div class="modal-widget add-md-video-modal">
    <div class="modal-container">
        <div class="modal-row">
            <h3>Message from MD & CEO</h3>
            <hr>
            <div class="input-row" id="bannerCeoErr">
                <label for="" class="input-label">Video Banner</label>
                <input type="file" class="input-file" id="md-video-banner">
                  <p class="input-info">Video dimension & resolution are within limited 420px X 250px and 450kb</p>
            </div>
            <div class="input-row" id="bannerCeoUrlErr" >
                <label for="" class="input-label">Url</label>
                <input type="text" class="input-ctrl" id="md-video-url" placeholder="Enter Title Url"
                       autocomplete="off">
            </div>
            <div class="btn-row justify-center">
                <button class="cancel-btn close-ceo-modal">Cancel</button>
                <input type="button" class="form-submit" id="md-modal-submit" value="Submit">
            </div>
        </div>
    </div>
</div>
<div class="tost-row" id="tost-row"></div>
<div class="tost-top" id="publish-success"></div>
<script>


</script>
<script src="./resources/js/jquery.min.js"></script>
<script src="./resources/js/jquery-ui.js"></script>
<script src="./resources/js/home.js"></script>
<script src="./resources/js/menu.js"></script>
<script src="./resources/js/custom.js"></script>
</body>
</html>



