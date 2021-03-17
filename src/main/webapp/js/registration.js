$(document).ready(function (){
    $("#command").click(function (){
        var name=$("#name").val();
        var surname=$("#surname").val();
        var phoneNumber=$("#phoneNumber").val();
        var login=$("#login").val();
        var password_1=$("#password_1").val();
        var birthDate=$("#birthDate").val();
        var passportNumber=$("#passportNumber").val();
        if(name==""){
            alert("Enter name");
        }
    });
});