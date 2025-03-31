package com.iot.iotprojectnew.controller;


import com.iot.iotprojectnew.dto.SePayWebhookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/sepay")
public class SePayWebhookController {

    private volatile long lastId = 0;
    private volatile String lastContent = "No content";
    private volatile long lastAmount = 0;

    @PostMapping("/webhook")
    public ResponseEntity<String> receiveWebhook(@RequestBody SePayWebhookDTO payload) {

        System.out.println("🔥 Giao dịch mới từ SePay:");
        System.out.println("ID: " + payload.getId());
        System.out.println("Ngân hàng: " + payload.getGateway());
        System.out.println("Số tiền: " + payload.getTransferAmount());
        System.out.println("Nội dung: " + payload.getContent());
        System.out.println("Loại giao dịch: " + payload.getTransferType());

        // ⚠️ Chỉ xử lý nếu là tiền vào
        if ("in".equalsIgnoreCase(payload.getTransferType())) {
            lastId = payload.getId();
            lastAmount = payload.getTransferAmount();  // ✅ Gán giá trị
            lastContent = payload.getContent();        // ✅ Gán giá trị

            System.out.println("✅ Đã lưu vào biến: " + lastId + " - " + lastContent + " - " + lastAmount);
        } else {
            System.out.println("❌ Bỏ qua: Giao dịch không phải tiền vào.");
        }

        return ResponseEntity.ok("OK");
    }


    // ✅ API để ESP8266 gọi
    @GetMapping("/latest-transaction")
    public Map<String, Object> getLatestTransaction() {
        Map<String, Object> response = new HashMap<>();
        response.put("id", lastId);
        response.put("amount", lastAmount);
        response.put("content", lastContent);
        return response;
    }



}