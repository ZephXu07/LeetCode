package 小工具;/**
 * Title: CompareFaceUI
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */


import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.CompareFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.CompareFaceResponse;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;


public class CompareFaceUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Chooser Sample");

        final FileChooser fileChooser = new FileChooser();

        final Button openButton1 = new Button("选择图片A");
        final Button openButton2 = new Button("选择图片B");

        final String[] image = new String[2];
        StringBuilder sb = new StringBuilder();
        TextArea textArea = new TextArea();

        textArea.setEditable(false);
        openButton1.setOnAction(
                (final ActionEvent e) -> {
                    File file = fileChooser.showOpenDialog(primaryStage);
                    if (file != null) {
                        image[0] = getImage(file);
                        sb.append("图片A已选择").append("\n");
                        textArea.setText(sb.toString());
                    }
                });

        openButton2.setOnAction(
                (final ActionEvent e) -> {
                    File file = fileChooser.showOpenDialog(primaryStage);
                    if (file != null) {
                        image[1] = getImage(file);
                        sb.append("图片B已选择").append("\n");
                        textArea.setText(sb.toString());

                        String[] res = compareFace(image).split(",");
                        res[0] += '}';
                        res[1] = '{' + res[1] + '}';
                        res[2] = '{' + res[2];
                        sb.append("结果：").append("\n").
                                append(res[0]).append("\n").
                                append(res[1]).append("\n").
                                append(res[2]).append("\n");

                        textArea.setText(sb.toString());
                    }
                });

        final GridPane inputGridPane = new GridPane();


        GridPane.setConstraints(openButton1, 0, 0);
        GridPane.setConstraints(openButton2, 1, 0);
        GridPane.setConstraints(textArea, 2, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton1, openButton2, textArea);




        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        primaryStage.setScene(new Scene(rootGroup));

        primaryStage.show();



    }

    public String compareFace(String[] image) {
        try{
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential("AKID07xKbUIZlKeQyOiXjfU4sPf0KRJw7GxP",
                    "LQIuhFYaWDdprxbNv86mEPlrjWBm8crt");
//            Credential cred = new Credential("",
//                    "");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("iai.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            IaiClient client = new IaiClient(cred, "ap-guangzhou", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            CompareFaceRequest req = new CompareFaceRequest();

            req.setImageA(image[0]);
            req.setImageB(image[1]);

            // 返回的resp是一个CompareFaceResponse的实例，与请求对象对应
            CompareFaceResponse resp = client.CompareFace(req);
            // 输出json格式的字符串回包
            return CompareFaceResponse.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e);
        }
        return "";
    }


    public String getImage(File file) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(Objects.requireNonNull(data));
    }


}
