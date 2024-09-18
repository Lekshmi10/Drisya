window.onload = function () {

    role=document.getElementById("user-role").value;
    console.log("role",role);
    if(role=="Drisya_Marketing_Team"){


    }else if(role=="Drisya_HR"){

        document.getElementById("home_data").style.opacity=0.5;
        document.getElementById("home_data").style.pointerEvents="none";


        document.getElementById("application_data").style.opacity=0.5;
        document.getElementById("application_data").style.pointerEvents="none";

        document.getElementById("reference_data").style.opacity=0.5;
        document.getElementById("reference_data").style.pointerEvents="none";

        document.getElementById("support_data").style.opacity=0.5;
        document.getElementById("support_data").style.pointerEvents="none";

        document.getElementById("retirementActivation_data").style.opacity=0.5;
        document.getElementById("retirementActivation_data").style.pointerEvents="none";



    }


}



