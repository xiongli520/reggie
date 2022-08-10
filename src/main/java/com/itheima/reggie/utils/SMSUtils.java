package com.itheima.reggie.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

/**
 * 短信发送工具类
 */
public class SMSUtils {

	/**
	 * 发送短信
	 * @param signName 签名
	 * @param templateCode 模板
	 * @param phoneNumbers 手机号
	 * @param param 参数
	 */
	public static void sendMessage(String signName, String templateCode,String phoneNumbers,String param){
		// DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tKYAuU8su1miZtfmesc", "0mOCGL0HC0axQ5e0rE9bXOlt0EG3Ki");
		// IAcsClient client = new DefaultAcsClient(profile);
		//
		// SendSmsRequest request = new SendSmsRequest();
		// request.setSysRegionId("cn-hangzhou");
		// request.setPhoneNumbers(phoneNumbers);
		// request.setSignName(signName);
		// request.setTemplateCode(templateCode);
		// request.setTemplateParam("{\"code\":\""+param+"\"}");
		// try {
		// 	SendSmsResponse response = client.getAcsResponse(request);
		// 	System.out.println("短信发送成功");
		// }catch (ClientException e) {
		// 	e.printStackTrace();
		// }

		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tKYAuU8su1miZtfmesc", "0mOCGL0HC0axQ5e0rE9bXOlt0EG3Ki");
		/** use STS Token
		 DefaultProfile profile = DefaultProfile.getProfile(
		 "<your-region-id>",           // The region ID
		 "<your-access-key-id>",       // The AccessKey ID of the RAM account
		 "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
		 "<your-sts-token>");          // STS Token
		 **/

		IAcsClient client = new DefaultAcsClient(profile);

		SendSmsRequest request = new SendSmsRequest();
		request.setPhoneNumbers(phoneNumbers);
		request.setSignName(signName);
		request.setTemplateCode(templateCode);
		request.setTemplateParam("{\"code\":"+ param +"}");

		try {
			SendSmsResponse response = client.getAcsResponse(request);
			System.out.println(new Gson().toJson(response));
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			System.out.println("ErrCode:" + e.getErrCode());
			System.out.println("ErrMsg:" + e.getErrMsg());
			System.out.println("RequestId:" + e.getRequestId());
		}
	}

}



