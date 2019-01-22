window.onload=function (ev) {
    var pagePerson=document.getElementById("page-person");
    var pageProject=document.getElementById("page-project");
    var pageSkill=document.getElementById("page-skill");

    var personBtn=document.getElementById("person-btn");
    var projectBtn=document.getElementById("project-btn");
    var skillBtn=document.getElementById("skill-btn");

    var topPage="pagePerson";

    personBtn.onclick=function () {
        if(topPage!="pagePerson"){
            switch (topPage) {
                case "pageProject":
                    pageProject.style.zIndex='1';
                    break;
                case  "pageSkill":
                    pageSkill.style.zIndex='1';
                    break;
            }
            pagePerson.style.zIndex="999";
            topPage="pagePerson";
        }
    }

    projectBtn.onclick=function () {
        if(topPage!="pageProject"){
            switch (topPage) {
                case "pagePerson":
                    pagePerson.style.zIndex='1';
                    break;
                case  "pageSkill":
                    pageSkill.style.zIndex='1';
                    break;
            }
            pageProject.style.zIndex="999";
            topPage="pageProject";
        }
    }

    skillBtn.onclick=function () {
        if(topPage!="pageSkill"){
            switch (topPage) {
                case "pageProject":
                    pageProject.style.zIndex='1';
                    break;
                case  "pagePerson":
                    pagePerson.style.zIndex='1';
                    break;
            }
            pageSkill.style.zIndex="999";
            topPage="pageSkill";
        }
    }

    personBtn.onmouseover=function () {
        personBtn.style.borderColor="darkslategray";
    }

    personBtn.onmouseout=function(){
        personBtn.style.borderColor="white";
    }

    projectBtn.onmouseover=function(){
        projectBtn.style.borderColor="darkslategray";
    }

    projectBtn.onmouseout=function(){
        projectBtn.style.borderColor="white";
    }

    skillBtn.onmouseover=function(){
        skillBtn.style.borderColor="darkslategray";
    }

    skillBtn.onmouseout=function(){
        skillBtn.style.borderColor="white";
    }


}