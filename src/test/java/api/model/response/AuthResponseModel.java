package api.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
public class AuthResponseModel {
    private Token token;

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties (ignoreUnknown = true)
    public static class Token {
        private String accessToken;
    }
}
