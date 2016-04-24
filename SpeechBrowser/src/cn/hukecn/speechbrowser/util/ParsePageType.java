package cn.hukecn.speechbrowser.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.R.string;

public class ParsePageType {
	//QQ�����¼ҳ
	public static final String MailLoginUrl = "ui.ptlogin2.qq.com/cgi-bin/login?style=";
	public static final int MailLoginTag = 1;
	
	//QQ�����½����ҳ
	public static final String MailHomePageUrl = "w.mail.qq.com/cgi-bin/today?sid=";
	public static final int MailHomePageTag = 8;
	
	//QQ�����ռ����б�ҳ
	public static final String MailListUrl = "w.mail.qq.com/cgi-bin/mail_list";
	public static final int MailListTag = 2;
	
	//QQ�����ʼ�����ҳ
	public static final String MailContentUrl = "w.mail.qq.com/cgi-bin/readmail";
	public static final int MailContentTag = 3;
	
	//��Ѷ���������б� aid = infocenter  aid = template
//	public static final String NewsListUrl = "info.3g.qq.com/g/s?icfa=infocenter&aid=template&tid=news_guoneiss&i_f=703";
	public static final String NewsListUrl1 = "aid=infocenter";
	public static final String NewsListUrl2 = "aid=template"; 
	public static final int NewsListTag = 4;
	//��Ѷ������������
//	public static final String NewsContentUrl = "info.3g.qq.com/g/s?icfa=news_guoneiss&aid=news_ss&id=news_";
	public static final String NewsContentUrl = "&id=news_20";
	public static final int NewsContentTag = 5;
	//��������
	public static final String SinaWeatherUrl = "weather1.sina.cn";
	public static final int SinaWeatherTag = 6;
	//�ٶ��������
	public static final String BaiduResultUrl = "m.baidu.com/s?word=";
	public static final int BaiduResultUrlTag = 7;
	
	//��Ѷ��ͼ
	public static final String TencentMapUrl = "map.qq.com/m/index/map";
	public static final int TencentMapUrlTag = 9;
	
	public static final int NoSupportTag = 99;
	private ParsePageType(){};
	
	public static int getPageType(String url){
		
		if(url == null || url.length() == 0)
			return NoSupportTag;
		
		if(url.indexOf(TencentMapUrl) != -1)
			return TencentMapUrlTag;
		
		if(url.indexOf(MailLoginUrl) != -1)
			return MailLoginTag;
		
		if(url.indexOf(MailHomePageUrl) != -1)
			return MailHomePageTag;
		
		if(url.indexOf(MailListUrl) != -1)
			return MailListTag;
		
		if(url.indexOf(MailContentUrl) != -1)
			return MailContentTag;
		
		if(url.indexOf(NewsListUrl1) != -1 || url.indexOf(NewsListUrl2) != -1)
			return NewsListTag;
		
		String regex = "&id=\\w*_\\d*&";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(url);
		if(m.find())
			return NewsContentTag;
		
//		if(url.indexOf(NewsContentUrl) != -1)
//			return NewsContentTag;
		
		if(url.indexOf(SinaWeatherUrl) != -1)
			return SinaWeatherTag;
		
		if(url.indexOf("m.baidu.com") != -1 && url.indexOf("/s?word=") != -1)
			return BaiduResultUrlTag;
		
		return NoSupportTag;
	}
}