/**
 * 
 */

function check(){
	if(form.mid.value == ""){
		alert("�û���Ų���Ϊ�գ�");
		form.mid.focus();
		return false;
	}
	
	if(form.wid.value == ""){
		alert("������Ų���Ϊ�գ�");
		form.wid.focus();
		return false;
	}
	
	var regm = /^[0-9]+$/;
	if(form.bcost.value !="" && !form.bcost.value.match(regm)){
		alert("��ʽ���ԣ�Ԥ��ֻ����������ɣ������������룡");
		form.bcost.focus();
		return false;
	}
	
	var regm = /^[0-9]+$/;
	if(form.acost.value !="" && !form.acost.value.match(regm)){
		alert("��ʽ���ԣ�����ֻ����������ɣ������������룡");
		form.acost.focus();
		return false;
	}
	
	if(form.bcost.value == ""){
		alert("������Ԥ�ƻ��ѣ�");
		form.bcost.focus();
		return false;
	}
	
	if(form.acost.value == ""){
		alert("������ʵ�ʻ��ѣ�");
		form.acost.focus();
		return false;
	}
	 
/*	if(form.password1.value != form.password2.value){
		alert("������������벻һ����");
		form.password2.focus("");
		return false;
	}*/
		
}