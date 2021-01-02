// JavaScript Document
function XuatCauChao(hoten)
{
	var chuoi="Chào bạn " + hoten;
	alert(chuoi);
}
function xep_loai(diem_tb1, diem_tb2)
{	
    
    if (isNaN(parseInt(diem_tb1)) || isNaN(parseInt(diem_tb2)) )
    {	
		xl.innerHTML = '';
        return 0;
    }
    hk1 = Number(diem_tb1);
    hk2 = Number(diem_tb2);
    hk = (hk1 + (hk2*2))/3;
    if (hk >=9) 
        {xl.innerHTML='Giỏi';} 
    else if (hk >=7)
        {xl.innerHTML='Khá';}
    else if (hk >=5)
        {xl.innerHTML='Trung bình';}
    else
        {xl.innerHTML='Yếu';}
    return hk;
}
function InBangCuuChuong(n)
{
		n = Number(n);
		var kq = "";
		for(i=1;i<=10;i++)
		{
			kq += n + "*" + i + " = " + n*i + "<br />";
		}
		return kq;
}
function HoverImage()
{
	var img = document.getElementById("hinh");
	img.src = "images/OngGiaNoel.jpg";
}
function OutImage()
{
	var img = document.getElementById("hinh");
	img.src = "images/NguoiTuyet.png";	
}
function thaydoicauchuc()
{
	var tag = document.getElementById("cauchuc");
	if (tag.innerHTML=="Merry Christmas!!!")
		tag.innerHTML ="Happy New Year!!!";
	else
		tag.innerHTML ="Merry Christmas!!!";
}