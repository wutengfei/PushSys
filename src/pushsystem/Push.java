package pushsystem;

import com.xiaomi.xmpush.server.*;

import config.ConfigLoader;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dell on 2017/3/9.
 */
public class Push extends HttpServlet{

    private static String MY_PACKAGE_NAME = "cn.cnu.pushsystem";
    private static String APP_SECRET_KEY = "5621755087805";
    private String regId = "xiaomipad";
    private static String topic = "xiaomipad";
/*
    public static void main(String agrs[]) {
        System.out.println("Hello world");
        try {
            sendBroadcast();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	try {
			sendBroadcast();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

    /**
     * Message是MiPush推送服务系统中的消息，开发者可以用它构建要发送的消息体。
     * 注:Message的实例是不可变对象(immutable)，由Builder或IOSBuilder来构建。
     * 打开Launcher Activity
     *
     * @return
     * @throws Exception
     */
    private Message buildMessage() throws Exception {

        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .passThrough(0)  //1为消息使用透传方式.0为通知栏消息
                .notifyType(1)     // 使用默认提示音提示
                .extra("flow_control", "4000")     // 设置平滑推送, 推送速度4000每秒(qps=4000)
                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_LAUNCHER_ACTIVITY)//打开Launcher Activity
                .build();
        return message;
    }

    private Message buildMessage_AnyActivity() throws Exception {
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .passThrough(0)  //消息使用通知栏方式
                .notifyType(1)
                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_ACTIVITY)
                .extra(Constants.EXTRA_PARAM_INTENT_URI,
                        "intent:#Intent;component=cn.cnu.pushsystem/.SecondActivity;end")//打开任意activity
                .build();
        return message;
    }

    //打开网页
    private Message buildMessage_web() throws Exception {
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .passThrough(0)  //消息使用通知栏方式
                .notifyType(1)
                .extra(Constants.EXTRA_PARAM_NOTIFY_EFFECT, Constants.NOTIFY_WEB)
                .extra(Constants.EXTRA_PARAM_WEB_URI, "http://www.xiaomi.com")//打开网页
                .build();
        return message;
    }


    /**
     * TargetedMessage封装了MiPush推送服务系统中的消息Message对象，和该Message对象所要发送到的目标。
     *
     * @return
     * @throws Exception
     */
    private List<TargetedMessage> buildMessages() throws Exception {
        List<TargetedMessage> messages = new ArrayList<TargetedMessage>();
        TargetedMessage message1 = new TargetedMessage();
        message1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, "alias1");
        message1.setMessage(buildMessage());
        messages.add(message1);
        TargetedMessage message2 = new TargetedMessage();
        message2.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, "alias2");
        message2.setMessage(buildMessage());
        messages.add(message2);
        return messages;
    }

    private void sendMessage() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        sender.send(message, regId, 0); //根据regID，发送消息到指定设备上，不重试。

        // Sender发送消息给服务器之后，服务器返回的结果
        Result result = sender.send(message, regId, 0); //Result对于sendToAlias()，broadcast()和send()调用方式完全一样
        System.out.println("Server response:MessageId: " + result.getMessageId() +
                " ErrorCode: " + result.getErrorCode().toString() +
                " Reason: " + result.getReason());
    }

    private void sendMessages() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        List<TargetedMessage> messages = new ArrayList<TargetedMessage>();
        TargetedMessage targetedMessage1 = new TargetedMessage();
        targetedMessage1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, "alias1");
        String messagePayload1 = "This is a message1";
        String title1 = "notification title1";
        String description1 = "notification description1";
        Message message1 = new Message.Builder()
                .title(title1)
                .description(description1).payload(messagePayload1)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        targetedMessage1.setMessage(message1);
        messages.add(targetedMessage1);
        TargetedMessage targetedMessage2 = new TargetedMessage();
        targetedMessage1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, "alias2");
        String messagePayload2 = "This is a message2";
        String title2 = "notification title2";
        String description2 = "notification description2";
        Message message2 = new Message.Builder()
                .title(title2)
                .description(description2).payload(messagePayload2)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        targetedMessage2.setMessage(message2);
        messages.add(targetedMessage2);
        sender.send(messages, 0); //根据alias，发送消息到指定设备上，不重试。
    }

    private void sendMessageToAlias() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        String alias = "testAlias";    //alias非空白，不能包含逗号，长度小于128。
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        sender.sendToAlias(message, alias, 0); //根据alias，发送消息到指定设备上，不重试。
    }

    private void sendMessageToAliases() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        List<String> aliasList = new ArrayList<String>();
        aliasList.add("testAlias1");  //alias非空白，不能包含逗号，长度小于128。
        aliasList.add("testAlias2");  //alias非空白，不能包含逗号，长度小于128。
        aliasList.add("testAlias3");  //alias非空白，不能包含逗号，长度小于128。
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        sender.sendToAlias(message, aliasList, 0); //根据aliasList，发送消息到指定设备上，不重试。
    }

    private static void sendBroadcast() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(APP_SECRET_KEY);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
       // sender.broadcast(message, topic, 0); //根据topic，发送消息到指定一组设备上，不重试。
        sender.broadcastAll(message, 0); //根据topic，发送消息所有设备上，不重试。
        System.out.println("sendBroadcast()执行了");
    }


}
