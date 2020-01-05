/**
 * 
 */

function check(){

	if(form.mname.value == ""){
		alert("用户名不能为空！");
		form.mname.focus();
		return false;
	}
	
	var regm = /^[a-z0-9]+$/;
	if(form.mname.value !="" && !form.mname.value.match(regm)){
		alert("用户名只能由小写字母和数字组成，请检查后重新输入！");
		form.mname.focus();
		return false;
	}
	
	if(form.mpassword.value == ""){
		alert("密码不可以修改为空！");
		form.mpassword.focus();
		return false;
	}
	
	var regm = /^[a-zA-Z0-9]+$/;
	if(form.mpassword.value !="" && !form.mpassword.value.match(regm)){
		alert("密码只能由字母和数字组成，请检查后重新输入！");
		form.mpassword.focus();
		return false;
	}

}