package cn.anondata.encryption.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {
    @GetMapping("/")
    @PostMapping("/")
    public String home() {
        StringBuffer sb = new StringBuffer();
        sb.append(
                "<p>This website provides basic cryptography APIs using bouncycastle(https://www.bouncycastle.org/) framework.</p>")
                .append("\n")
                .append("<p>Only study purpose is allowed.</p>")
                .append("\n")
                .append("<p>Feel safe to friendly use and <b>\"No data is collected by this website.\"</b></p>")
                .append("\n")
                .append("<p>More details could be found in repo JunjieChou/encryption(https://github.com/JunjieChou/encryption), and welcome for suggestions and prs.</p>");
        return sb.toString();
    }
}
