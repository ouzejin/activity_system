/**
 * 
 */

function allcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
/*		ע�ⲻҪд���ʣ�form��from��ture��true��ͨ����ɫ�ı�ɿ���*/
		oCheck[i].checked=true;
	}
}

function delAllWork(){
	var allwid = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
		allwid.push(oCheck[i].value);
		flag = true;
		}
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateWork?f=delall&allwid="+allwid;
		}
	}else { 
		alert("������Ҫѡ��һ����¼�����ܽ�������ɾ����");
	}
/*	����alert(allwid);������û��ȡ��ID */
}
