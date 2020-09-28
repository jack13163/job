package job.mapper;

import job.model.WebSite;

import java.util.List;

/**
 * 网站查询mapper
 */
public interface WebSiteMapper {
    // 查询所有的网站信息
    List<WebSite> getAllWebSites();
}
