
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/fonts/stylesheet.css">
    <link rel="stylesheet" href="./resources/css/style.css">
    <link rel="stylesheet" href="./resources/css/retirement.css">
        <link rel="stylesheet" href="./resources/css/Errorstyle.css">
    
    <script src="./resources/js/jquery.js" type="text/javascript"></script>
    <link href="./resources/css/spin_loader.css" rel="stylesheet">
    <script src="./resources/js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="./resources/js/retirement.js" type="text/javascript"></script>
    <title>Drisya | Retirements</title>
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
                    <a href="#" class="logo-icon">
                        <img src="./resources/images/logo-icon.png" alt="">
                    </a>
                    <button class="toggle-sm">
                        <svg width="23" height="16.45" viewBox="0 0 23 16.45"><g transform="translate(-400 -942.55)"><path class="def" d="M21,18v2H3V18ZM6.95,3.55v9.9L2,8.5,6.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z" transform="translate(402 939)" fill="#707070"/><path class="hov" d="M21,18v2H3V18ZM2.95,3.55v9.9L-2,8.5,2.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z" transform="translate(402 939)" fill="#707070"/></g></svg>
                    </button>
                </div>
                <nav class="sidebar-navigation">
                    <ul>
                        <li>
                            <a href="./home" id="home_data">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path d="M80 212v236a16 16 0 0016 16h96V328a24 24 0 0124-24h80a24 24 0 0124 24v136h96a16 16 0 0016-16V212" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"></path><path d="M480 256L266.89 52c-5-5.28-16.69-5.34-21.78 0L32 256M400 179V64h-48v69" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"></path></svg>
                                </span>
                                <span class="nav-text">Home Page</span>
                            </a>
                        </li>
                        <li>
                            <a href="./application" id="application_data">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path d="M440 432H72a40 40 0 01-40-40V120a40 40 0 0140-40h75.89a40 40 0 0122.19 6.72l27.84 18.56a40 40 0 0022.19 6.72H440a40 40 0 0140 40v240a40 40 0 01-40 40zM32 192h448" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"></path></svg>
                                </span>
                                <span class="nav-text">Applications Page</span>
                            </a>
                        </li>
                        <li>
                            <a href="./reference" id="reference_data">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><title>People</title><path d="M402 168c-2.93 40.67-33.1 72-66 72s-63.12-31.32-66-72c-3-42.31 26.37-72 66-72s69 30.46 66 72z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"></path><path d="M336 304c-65.17 0-127.84 32.37-143.54 95.41-2.08 8.34 3.15 16.59 11.72 16.59h263.65c8.57 0 13.77-8.25 11.72-16.59C463.85 335.36 401.18 304 336 304z" fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="32"></path><path d="M200 185.94c-2.34 32.48-26.72 58.06-53 58.06s-50.7-25.57-53-58.06C91.61 152.15 115.34 128 147 128s55.39 24.77 53 57.94z" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"></path><path d="M206 306c-18.05-8.27-37.93-11.45-59-11.45-52 0-102.1 25.85-114.65 76.2-1.65 6.66 2.53 13.25 9.37 13.25H154" fill="none" stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="32"></path></svg>
                                </span>
                                <span class="nav-text">Reference Pages</span>
                            </a>
                        </li>
                        <li>
                            <a href="./support" id="support_data">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path d="M160 164s1.44-33 33.54-59.46C212.6 88.83 235.49 84.28 256 84c18.73-.23 35.47 2.94 45.48 7.82C318.59 100.2 352 120.6 352 164c0 45.67-29.18 66.37-62.35 89.18S248 298.36 248 324" fill="none" stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="40"/><circle cx="248" cy="399.99" r="32"/></svg>
                                </span>
                                <span class="nav-text">Support Page</span>
                            </a>
                        </li>
                        <li>
                            <a href="./retirement">
                                <span class="icon">
                                    <svg width="19px" height="19px" class="ionicon" viewBox="0 0 512 512"><path d="M416 221.25V416a48 48 0 01-48 48H144a48 48 0 01-48-48V96a48 48 0 0148-48h98.75a32 32 0 0122.62 9.37l141.26 141.26a32 32 0 019.37 22.62z" fill="none" stroke="currentColor" stroke-linejoin="round" stroke-width="32"/><path d="M256 56v120a32 32 0 0032 32h120" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"/></svg>
                                </span>
                                <span class="nav-text">Retirement</span>
                            </a>
                        </li>
                         <li>
                             <a href="./retirementActivation" id="retirementActivation_data">
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
                        <svg width="23" height="16.45" viewBox="0 0 23 16.45"><g transform="translate(-400 -942.55)"><path class="def" d="M21,18v2H3V18ZM6.95,3.55v9.9L2,8.5,6.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z" transform="translate(402 939)" fill="#707070"/><path class="hov" d="M21,18v2H3V18ZM2.95,3.55v9.9L-2,8.5,2.95,3.55ZM21,11v2H12V11Zm0-7V6H12V4Z" transform="translate(402 939)" fill="#707070"/></g></svg>
                    </button>
                     <div class="template-ctrl">

                    </div>
                     <div class="user-control">
                        <div class="user-head"><!--open-->
                            <img src="./resources/retirementimages/avatar-f.jpg" alt=""  onclick="signOut()">
                            <div class="user-name"><% out.print(session.getAttribute("uname")); %></div>
                            <input class="user-role" id="user-role" value="<% out.print(session.getAttribute("role"));%>" style="display: none"></input>
                        </div>
                    </div>
                </div>
                <div Id="signout" style="display:none;">
                <a href="./signout" class="signout-div">Signout</a>
            </div>
                    <div class="template-card">
                        <h3>Retirement</h3>
                        <hr class="mb-15">
                        </div>
                              <div class="content-row bg-gray pl-0 pr-0">
                <div class="template-row" id="upload">
                    <div class="retirement-row">
                        <div class="retirement-col">
                            <h2>RETIREMENTS</h2>
                            <form id="formdataret" class="input-row" enctype="multipart/form-data">
                                <label for="">Choose file</label>
                                <div class="input-file">
                                    <input class="input-ctrl" id="fileid" type="file" >
                                    
                                </div>
                            </form>
                            <div class="button-row">
                                <button id="buttonret" class="form-submit">Submit</button>
                            </div>
                        </div>
                        <div class="retirement-col">
                            <h2>VRS</h2>
                            <form id="formdataret" class="input-row" enctype="multipart/form-data">
                                <label for="">Choose file</label>
                                <div class="input-file">
                                    <input class="input-ctrl" id="fileidvrs" type="file">
                                </div>
                            </form>
                            <div class="button-row">
                                <button id="buttonvrs" class="form-submit">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
                
                  <div class="template-row hidden" id="view">
                    <div class="retirement-view-row"> 
                        <h2 id="headingret1">RETIREMENTS</h2>
                        <h2 id="headingret2" class="hidden">RETIREMENTS PREVIEW</h2>
                        <h2 id="headingvrs1" class="hidden">VRS</h2>
                        <h2 id="headingvrs2" class="hidden">VRS PREVIEW</h2>
                        
                        
                        <marquee direction="left" class="marquee" id="floating_alerts"><p>May happiness, prosperity and good health light up your life as the warmth of the Sun. Thanking you for your sincere effort and selfless service.
            </p></marquee>
                        <div class="retirement-view-col anniversary-row" id="retirement-view-col" >
                             
                        </div>
                         <div class="retirement-view-btn">
                                <button class="publish-btn" id="publishbutton">Preview</button>
                                <button class="publish-btn hidden" id="publishbuttonConfirm" onclick="spinner()">Publish</button>
                                <button class="publish-btn hidden" id="publishbuttonvrs">Preview</button>
                                <button class="publish-btn hidden" id="publishbuttonConfirmvrs" onclick="spinner()">Publish</button>
                            </div>
                    </div>
                </div>
                
                <div class="error-container hidden" id="error">
                     <div class="error-row">
                      <h2>404</h2>
                      <p>The requested URL was not found on this server</p>
                      <a class="page-btn" href="/retirement">Back to Home</a>
                      </div>
               </div>
                <div class="error-container hidden" id="errornotexist">
                     <div class="error-row">
                      <h2>Sorry</h2>
                      <%-- <h4>${message}</h4> --%>
                      <p>The requested PF number does not exist. Please check the PF numbers entered and reupload.</p>
                      <a class="page-btn" href="/retirement">Back to Home</a>
                      </div>
               </div>
                <div class="error-container hidden" id="errorspace">
                     <div class="error-row">
                      <h2>Sorry</h2>
                      <%-- <h4>${message}</h4> --%>
                      <p>File contains empty rows.Please check the file and reupload.</p>
                      <a class="page-btn" href="/retirement">Back to Home</a>
                      </div>
               </div>
                <div id="dataObj" style="display:none;"></div>
            <div id="dataObjVrs" style="display:none;"></div>
            </div>
                       <!--  <div class="retirement-row">
                            <div class="retirement-col">
                                <h3>Retirements</h3>
                                <hr class="mb-15">
                                <div class="input-row">
                                    <label for="">Choose file</label>
                                    <div class="input-file-row">
                                        <input class="input-ctrl" type="file">
                                    </div>
                                    <span class="validate-text">field is required</span>
                                </div>
                                <div class="button-row">
                                    <button class="form-submit">Submit</button>
                                </div>
                            </div>
                            <div class="retirement-col">
                                <h3>VRS</h3>
                                <hr class="mb-15">
                                <div class="input-row">
                                    <label for="">Choose file</label>
                                    <div class="input-file-row">
                                        <input class="input-ctrl" type="file">
                                    </div>
                                    <span class="validate-text">field is required</span>
                                </div>
                                <div class="button-row">
                                    <button class="form-submit">Submit</button>
                                </div>
                            </div> -->
                        </div>
                    <!--     <div class="anim-container">
                            <div class="balloon"></div>
                            <div class="balloon"></div>
                            <div class="balloon"></div>
                            <div class="balloon"></div>
                            <div class="balloon"></div>
                            <div class="balloon"></div>
                            <div class="balloon"></div>
                            <div class="balloon"></div>
                        </div> -->


                        <div id="loader_edit" style="display: none">
                            <div class="box"></div>
                            <div class="box overlay"></div>
                            <div class="spinner_style"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="tost-top" id="publish-success"></div>
    <script src="./resources/js/jquery.min.js"></script>
    <script>
		$(document).ready(function() {
			/* $('#headingret2').hide();
			 $('#headingvrs2').hide();
			 $('#backbtn2').hide(); */
			
			$('#buttonret').on('click', function(e) {
				 e.preventDefault();
				//var formTag=$("#formdata")[0];
				var file = $('#fileid').val();
				var filename = document.getElementById('fileid').value;
				//alert(filename.split("\\").pop());
				var hash={
						'.xls' : 1,
						'.xlsx' : 1,
				};
				var re= /\..+$/;
				var ext=filename.match(re);
				 if(file === ""){
					alert("Please upload the file");
					returned=false;
					return false;
				}else if(hash[ext]){
				//	alert("valid file");
					
				}else{
					console.log(ext);
					alert("Invlid file, Please upload an excel file.");
					return false;
				}
				var formData=new FormData();
				
				//formData.append("file",$(this)[0].files[0]);
				formData.append("file",$('#fileid').prop('files')[0]);
			
				$.ajax({
					url : "./uploadRetirement",
					method : "POST",
					type:"POST",
					data:formData,
					cache:false,
					contentType:false,
					processData:false,
					
                    beforeSend:function(){
                    	
                    	console.log("hidden");
                    	 $('#headingret2').hide();
						//$('#cheque').attr("disabled",true);
						//$('#loader').removeClass('hidden');
					},
					
					success : function(data) {
						if(data==""){
							alert("Error");
							$('#errornotexist').removeClass('hidden');	
						}else{
						
						
						console.log(data);
						var jsonarr;
						//var data_arr=JSON.parse(data);
						const jsondata=JSON.stringify(data);
						const json_arr=JSON.parse(jsondata);
						console.log("Date "+json_arr.data);
						console.log("Date "+json_arr.data.pfNumber);
						//document.getElementById("dataObj").value=jsondata;
						//var datab=document.getElementById("dataObj").value;
						//const jsonDatab=JSON.parse(datab);
						//const jsondata=JSON.stringify(datab);
						
						//console.log("Date "+jsonDatab.data.pfNumber);
						//console.log("Date "+jsondata.data.pfnum[0]);
						 for(var i=0;i<=json_arr.data.length-1;i++){
							 console.log("SPACE "+json_arr.data[0].pfNumber);
							 if(json_arr.data[0].pfNumber=="null"){
								 alert("Error");
								$('#errorspace').removeClass('hidden');	
							 }else if(json_arr.data[0].pfNumber=="characters"){
								 alert("Error");
									$('#errornotexist').removeClass('hidden');	
							 }
								 else{
								 $('#view').removeClass('hidden');
							 var n=document.getElementById("retirement-view-col");
							 var a = document.createElement("div");
							 var b = document.createElement("img");
							 var c = document.createElement("div");
							 var d = document.createElement("div");
							 var e = document.createElement("div");
							 var f = document.createElement("div");
							 var g = document.createElement("div");
							 var h = document.createElement("div");
							 var l = document.createElement("div");
							 var m = document.createElement("button");
							 b.src ="https://am.federalbank.co.in/EmpImage/imgs/"+json_arr.data[i].pfNumber+".jpg";
							 json_arr.data[i].image="https://am.federalbank.co.in/EmpImage/imgs/"+json_arr.data[i].pfNumber+".jpg";
							 console.log("Date "+ b.src);
							 e.className = "emp-code";
							 f.className = "exp";
							 g.className = "designation";
							 h.className = "department";
							 a.className = "anniversary-list";
							 c.className = "content";
							 d.className = "name";
							 l.className = "retirement-view-btn";
							 m.className = "publish-btn";
							 const date_str=json_arr.data[i].date;
							 const date_split=date_str.split(" ");
							  const split_date=new Date(date_split[0]);
							  var month_diff=Date.now()-split_date.getTime();
							  var exp_dt=new Date(month_diff);
							  var year=exp_dt.getUTCFullYear();
							  var exp=Math.abs(year-1970);
							  
							 // console.log("Date "+exp);
							  
							
							// console.log(data_arr.data[0].pfnum);
							 const namenode=document.createTextNode(json_arr.data[i].name);
							 const pfnumnode=document.createTextNode(json_arr.data[i].pfNumber);
							 
							 const joindatenode= document.createTextNode(exp+" Years Of Excellence");
							
							 const excllncenode=joindatenode;
							
							 const designationnode=document.createTextNode(json_arr.data[i].designation);
							 const departtmentnode=document.createTextNode(json_arr.data[i].department);
							 const imagenode=document.createTextNode(b);
							 n.appendChild(a), a.appendChild(b),   a.appendChild(c), d.appendChild(namenode), e.appendChild(pfnumnode),f.appendChild(excllncenode), g.appendChild(designationnode), h.appendChild(departtmentnode),  c.appendChild(d), c.appendChild(e),  c.appendChild(f), c.appendChild(g), c.appendChild(h);
							 jsonarr=JSON.stringify(json_arr);
							 
							 
							// console.log(date.getFullYear());
						 }
						 document.getElementById("dataObj").value=jsonarr;
						 }
						 //console.log("JSON DATA"+jsonarr);
						// console.log(JSON.stringify(data));
						}
					},
					complete: function(){
						 console.log("Complete");
						 $('#upload').hide();
							$('#backbtn2').removeClass('hidden');
						 $('#formdataret').hide();
						 $('#headingret2').hide();
						 $('#vrs').hide();
						$('#publishbutton').removeClass('hidden');
						$('#publishbuttonConfirm').hide();
						
						$('#backbtn2').removeClass('hidden');
						$('#backbtn2').show();
						// $('#backbtn1').hide();
					},
					error : function(data) {
						alert("Error");
						$('#error').removeClass('hidden');	
						 $('#publishbutton').hide();
						 $('#headingvrs1').hide();
						 $('#formdatavrs').hide();
								    }
				});
				
			});
			
				$('#buttonvrs').on('click', function(e) {
					 e.preventDefault();
					//var formTag=$("#formdata")[0];
					 var file = $('#fileidvrs').val();
					 var filename = document.getElementById('fileidvrs').value;
						//alert(filename.split("\\").pop());
						var hash={
								'.xls' : 1,
								'.xlsx' : 1,
						};
						var re= /\..+$/;
						var ext=filename.match(re);
						if(file === ""){
							alert("Please upload the file");
							returned=false;
							return false;
						}else if(hash[ext]){
						//	alert("valid file");
							
						}else{
							console.log(ext);
							alert("Invlid file, Please upload an excel file.");
							return false;
						}
					var formData=new FormData();
					
					//formData.append("file",$(this)[0].files[0]);
					formData.append("file",$('#fileidvrs').prop('files')[0]);

					
					$.ajax({
						url : "./uploadVrs",
						method : "POST",
						type:"POST",
						data:formData,
						cache:false,
						contentType:false,
						processData:false,
						
						beforeSend:function(){
							// $('#backbtn1').hide();
							//$('#cheque').attr("disabled",true);
							//$('#loader').removeClass('hidden');
						},
						
						success : function(data) {
							if(data==""){
								alert("Error");
								$('#errornotexist').removeClass('hidden');	
							}
							else{
								var jsonarr;
							//var data_arr=JSON.parse(data);
							const jsondata=JSON.stringify(data);
							const json_arr=JSON.parse(jsondata);
							console.log("Date "+json_arr.data);
							console.log("Date "+json_arr.data.pfNumber);
							//console.log("Date "+jsondata.data.pfNumber[0]);
							 for(var i=0;i<=json_arr.data.length-1;i++){
								 console.log("SPACE "+json_arr.data[0].pfNumber);
								 if(json_arr.data[0].pfNumber=="null"){
									 alert("Error");
									$('#errorspace').removeClass('hidden');	
								 }else if(json_arr.data[0].pfNumber=="characters"){
									 alert("Error");
										$('#errornotexist').removeClass('hidden');	
								 }
								 else{
									 $('#view').removeClass('hidden');
								 var n=document.getElementById("retirement-view-col");
								 var a = document.createElement("div");
								 var b = document.createElement("img");
								 var c = document.createElement("div");
								 var d = document.createElement("div");
								 var e = document.createElement("div");
								 var f = document.createElement("div");
								 var g = document.createElement("div");
								 var h = document.createElement("div");
								 b.src ="https://am.federalbank.co.in/EmpImage/imgs/"+json_arr.data[i].pfNumber+".jpg";
								 json_arr.data[i].image="https://am.federalbank.co.in/EmpImage/imgs/"+json_arr.data[i].pfNumber+".jpg";
								 console.log("Date "+ b.src);
								 e.className = "emp-code";
								 f.className = "exp";
								 g.className = "designation";
								 h.className = "department";
								 a.className = "anniversary-list";
								 c.className = "content";
								 d.className = "name";
								 const date_str=json_arr.data[i].date;
								 const date_split=date_str.split(" ");
								  const split_date=new Date(date_split[0]);
								  var month_diff=Date.now()-split_date.getTime();
								  var exp_dt=new Date(month_diff);
								  var year=exp_dt.getUTCFullYear();
								  var exp=Math.abs(year-1970);
								 // console.log("Date "+exp);
								  
								
								 //console.log(data_arr.data[0].pfnum);
								 const namenode=document.createTextNode(json_arr.data[i].name);
								 const pfnumnode=document.createTextNode(json_arr.data[i].pfNumber);
								 
								 const joindatenode= document.createTextNode(exp+" Years Of Excellence");
								
								 const excllncenode=joindatenode;
								
								 const designationnode=document.createTextNode(json_arr.data[i].designation);
								 const departtmentnode=document.createTextNode(json_arr.data[i].department);
								 const imagenode=document.createTextNode(b);
								 n.appendChild(a), a.appendChild(b),   a.appendChild(c), d.appendChild(namenode), e.appendChild(pfnumnode),f.appendChild(excllncenode), g.appendChild(designationnode), h.appendChild(departtmentnode),  c.appendChild(d), c.appendChild(e),  c.appendChild(f), c.appendChild(g), c.appendChild(h);
								 console.log("Date "+json_arr.data[i].pfNumber);
								 jsonarr=JSON.stringify(json_arr);
								 
								// console.log(date.getFullYear());
							 }
							 document.getElementById("dataObjVrs").value=jsonarr;
							 //console.log("JSON DATA"+jsonarr);
							 }
							 }
							// console.log(JSON.stringify(data));
						},
						complete: function(){
							// $('#backbtn1').hide();
							$('#upload').hide();
							$('#backbtn2').removeClass('hidden');
							$('#headingret1').hide();
							$('#headingvrs1').removeClass('hidden');
							$('#publishbutton').hide();
							  $('#formdatavrs').hide();
								 $('#headingvrs2').hide();
								$('#publishbuttonvrs').removeClass('hidden');
								$('#publishbuttonConfirmvrs').hide();
						},
						error : function(data) {
							alert("Error");
							$('#error').removeClass('hidden');	
							 $('#publishbuttonvrs').hide();   
							 $('#headingret1').hide();
							 $('#formdataret').hide();	
							 $('#headingvrs1').hide();
							 $('#headingvrs3').removeClass('hidden');
									    }
					});
					
				});
			 
			$('#publishbutton').on('click', function(e) {
				$('#backbtn2').removeClass('hidden');
				$('.anim-container').removeClass('hidden');
				// $('#backbtn1').hide();
				$('#headingret2').removeClass('hidden');
				$('#headingret2').show();
				//$('#formdataret').hide();
			//	$('#formdatavrs').hide();
				$('#headingvrs1').hide();
				$('#headingret1').hide();
				$('#vrs').hide();
				$('#publishbutton').hide();
				$('#publishbuttonConfirm').removeClass('hidden');
				$('#publishbuttonConfirm').show();
				var datab=document.getElementById("dataObj").value;
				
				//const jsondata=JSON.stringify(datab);
				//console.log("Date "+datab);
				//console.log("Date "+datab.data.pfnum[0]);
				
			});
			

			$('#publishbuttonConfirm').on('click', function(e) {
				var datab=document.getElementById("dataObj").value;
				var flag=0;
				console.log("Date "+datab);
				$.ajax({
					url : "./api/retirementPublish",
					method : "POST",
					type:"POST",
					data:datab,
					contentType: "application/json; charset=utf-8",
					
		           
					beforeSend:function(){
						$('#body').css('opacity','0.5');
						 $('#backbtn1').hide();
						$('#headingret2').removeClass('hidden');
						$('#headingret2').show();
						$('#formdataret').hide();
						$('#formdatavrs').hide();
						$('#headingvrs1').hide();
						$('#headingret1').hide();
						$('#publishbutton').hide();
						$('#publishbuttonConfirm').removeClass('hidden');
						$('#publishbuttonConfirm').show();
						$('#loader').removeClass('hidden');
					},
					success : function(data) {
						console.log("Date "+data);
						alert("Successfully published");
						window.location="./retirement";
						
						//window.location.reload();
						
					},
					complete: function(){
						$('#backbtn2').removeClass('hidden');
						$('#body').css('opacity','1');
						$('#loader').addClass('hidden');
					},
					error : function(e) {
						alert("Error");
						$('#error').removeClass('hidden');	
						$('#retirement').hide(); 
						$('#publishbuttonConfirm').hide();
					}
				//alert("Successfully published");
				// $('#backbtn1').hide();
				
			/*	$.ajax({
					url : "./home",
					method : "GET",
					
					beforeSend:function(){
						
					},
					success : function(data) {
						alert("Successfully published");
					},
					complete: function(){
					
					},
					error : function(data) {
					
					}
				})  */
			});
			});
				
			
			$('#publishbuttonvrs').on('click', function(e) {
				// $('#backbtn1').hide();
				$('#backbtn2').removeClass('hidden');			 
				$('.anim-container').removeClass('hidden');
				$('#headingvrs2').removeClass('hidden');
				$('#headingvrs2').show();
				$('#formdataret').hide();
				$('#formdatavrs').hide();
				$('#headingvrs1').hide();
				$('#headingret1').hide();
				$('#headingret2').hide();
				$('#publishbutton').hide();
				$('#publishbuttonConfirm').hide();
				$('#publishbuttonvrs').hide();
				$('#publishbuttonConfirmvrs').removeClass('hidden');
				$('#publishbuttonConfirmvrs').show();
			});
			
			$('#publishbuttonConfirmvrs').on('click', function(e) {
				var datab=document.getElementById("dataObjVrs").value;
				console.log("Date "+datab);
				$.ajax({
					url : "./api/vrsPublish",
					method : "POST",
					type:"POST",
					data:datab,
					contentType: "application/json; charset=utf-8",
			      
					beforeSend:function(){
				
				// $('#backbtn1').hide();
				$('#body').css('opacity','0.5');
				$('#headingvrs2').removeClass('hidden');
				$('#headingvrs2').show();
				$('#formdataret').hide();
				$('#formdatavrs').hide();
				$('#headingvrs1').hide();
				$('#headingret1').hide();
				$('#headingret2').hide();
				$('#publishbutton').hide();
				$('#publishbuttonConfirm').hide();
				$('#publishbuttonvrs').hide();
				$('#publishbuttonConfirmvrs').removeClass('hidden');
				$('#publishbuttonConfirmvrs').show();
				$('#loader').removeClass('hidden');
				
				},
				success : function(data) {
					console.log("Date "+data);
					alert("Successfully published");
					window.location="./retirement";
					
					//window.location.reload();
					
				},
				complete: function(){
					/* $('#backbtn2').removeClass('hidden'); */
					$('#body').css('opacity','1');
					$('#loader').addClass('hidden');
				},
				error : function(e) {
					alert("Error");
					$('#error').removeClass('hidden');	
					$('#vrs').hide(); 
					$('#publishbuttonConfirmvrs').hide();
				}
			});
			});
			
		});
			$(document).ready(function() {
				$('.backbtn1').on('click', function() {
					parent.history.back();
							});
						});
			function signOut(){

			    var signout=document.getElementById("signout");
			    if(signout.style.display=="none"){
			        signout.style.display="flex";
			    }
			    else{

			        signout.style.display="none";
			    }
			}
</script>
</body>
</html>