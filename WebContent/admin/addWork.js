/**
 * 
 */


function check(){
	if(form.wid.value == ""){
		alert("工作编号不能为空！");
		form.wid.focus();
		return false;
	}
	
	if(form.wname.value == ""){
		alert("工作名不能为空！");
		form.wname.focus();
		return false;
	}
	
	var regm = /^[0-9]+$/;
	if(form.etime.value !="" && !form.etime.value.match(regm)){
		alert("时间格式不对，只能由数字组成，请检查后重新输入！");
		form.etime.focus();
		return false;
	}
	
	
	var regm = /^[0-9]+$/;
	if(form.atime.value !="" && !form.atime.value.match(regm)){
		alert("时间格式不对，只能由数字组成，请检查后重新输入！");
		form.atime.focus();
		return false;
	}
	
	if(form.etime.value == ""){
		alert("请输入预计时间！");
		form.etime.focus();
		return false;
	}
	
	if(form.atime.value == ""){
		alert("请输入完成时间！");
		form.atime.focus();
		return false;
	}
	
	/*if(form.password1.value != form.password2.value){
		alert("两次输入的密码不一样！");
		form.password2.focus("");
		return false;
	}*/
		
}