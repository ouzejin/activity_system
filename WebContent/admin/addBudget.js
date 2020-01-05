/**
 * 
 */

function check(){
	if(form.mid.value == ""){
		alert("用户编号不能为空！");
		form.mid.focus();
		return false;
	}
	
	if(form.wid.value == ""){
		alert("工作编号不能为空！");
		form.wid.focus();
		return false;
	}
	
	var regm = /^[0-9]+$/;
	if(form.bcost.value !="" && !form.bcost.value.match(regm)){
		alert("格式不对，预算只能由数字组成，检查后重新输入！");
		form.bcost.focus();
		return false;
	}
	
	var regm = /^[0-9]+$/;
	if(form.acost.value !="" && !form.acost.value.match(regm)){
		alert("格式不对，花费只能由数字组成，检查后重新输入！");
		form.acost.focus();
		return false;
	}
	
	if(form.bcost.value == ""){
		alert("请输入预计花费！");
		form.bcost.focus();
		return false;
	}
	
	if(form.acost.value == ""){
		alert("请输入实际花费！");
		form.acost.focus();
		return false;
	}
	 
/*	if(form.password1.value != form.password2.value){
		alert("两次输入的密码不一样！");
		form.password2.focus("");
		return false;
	}*/
		
}