package main;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

@Document(indexName = "news", type="doc")
@Mapping(mappingPath = "/mappings/es_mappings.json")
public class NewsPost {
    @JsonProperty("id")
    private String id;
    @JsonProperty("dateTime")
    private String dateTime;
    @JsonProperty("header")
    private String header;
    @JsonProperty("body")
    private String body;


    @JsonCreator
    public NewsPost(@JsonProperty("id") final String id, @JsonProperty("dateTime") final String dateTime,
                    @JsonProperty("header") final String header, @JsonProperty("body") final String body) {
        this.id = id;
        this.dateTime = dateTime;
        this.header = header;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
