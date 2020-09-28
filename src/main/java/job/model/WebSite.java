package job.model;

import lombok.Data;

@Data
public class WebSite {
    private Integer id;
    private String name;
    private String url;
    private int alexa;
    private String country;
}
