package job.controller;

import job.mapper.WebSiteMapper;
import job.model.WebSite;
import job.validation.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebSiteController {

    @Autowired
    WebSiteMapper webSiteMapper;

    /**
     * 测试数据库查询
     * @return
     */
    @RequestMapping("/website")
    public JsonResult getAllWebSites(){
        List<WebSite> allWebSites = webSiteMapper.getAllWebSites();
        return new JsonResult(10086, allWebSites.toString());
    }
}
