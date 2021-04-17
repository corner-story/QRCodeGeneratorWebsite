package com.qrcode.web.controller;

import com.qrcode.QRCode;
import com.qrcode.web.Bean.QRCodeArgs;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/qrcode/", method = RequestMethod.POST)
    @ResponseBody
    public Object getQRCode(@RequestBody QRCodeArgs qrCodeArgs){
        System.out.println(qrCodeArgs);
        QRCode qrCode = new QRCode();
        HashMap<String, String> ans = new HashMap<>();
        try {
            String bits = qrCode.makeQRCode(qrCodeArgs.getData(), qrCodeArgs.getRSLevel(), qrCodeArgs.getQRVersion());
            String imageName = "QRCode" + System.currentTimeMillis() + ".png";
            qrCode.saveQRCode(
                    bits
                    ,"./images/" + imageName
                    , QRCodeArgs.convertColor(qrCodeArgs.getFinderColor())
                    , QRCodeArgs.convertColor(qrCodeArgs.getDataColor())
                    , qrCodeArgs.getPixelSize()
                    , qrCodeArgs.getBorderSize()
                    , null);
            ans.put("status", "success");
            ans.put("url", "/getImage?imageName=" + imageName);
        }catch (Exception e){
            e.printStackTrace();
            ans.put("status", "fail");
            ans.put("error", e.toString());
        }
        return ans;
    }

    @RequestMapping(value = "/getImage", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getImage(@RequestParam String imageName){
        String imagePath = "./images/" + imageName;
        File file = new File(imagePath);
        byte[] bytes = new byte[]{0};
        try{
            FileInputStream inputStream = new FileInputStream(file);
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            inputStream.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return bytes;
    }
}
