package api.model.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartResponseModel {
    private Integer addBonuses;
    private Integer cost;
    private Integer costGiftWrap;
    private Integer costWithBonuses;
    private Integer costWithSale;
    private Product [] disabledProducts;////????????
    private Integer discount;
    private String [] gifts;//????????
    private Product [] preorderProducts;//????????
    private Product[] products;
    private String promoCode;//????????
    private Integer weight;//////////

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties (ignoreUnknown = true)
    public static class Product {
        private Autors [] authors;
        private Category category;
        private String [] categoryChain;
        private Autors [] coauthors;//?????????
        private Integer cost;
        private Boolean disabledBonuses;
        private Integer fullCost;
        private Integer fullPrice;
        private Integer goodsId;//?????????
        private Integer id;//?????????
        private Boolean inSubscription;
        private Boolean isBook;
        private Boolean isBookmarks;
        private Boolean isMagic;
        private NForM nForM;//???????
        private Integer oldPrice;
        private String picture;
        private Boolean preOrder;
        private Integer price;
        private String publisher;
        private Integer quantity;
        private Boolean sale;
        private String status;
        private Integer stock;
        private String title;
        private String url;
        private Integer weight;
    }

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties (ignoreUnknown = true)
    public static class Autors {
        private String firstName;
        private Integer id;
        private Boolean isForeignAgent;
        private String lastName;
        private String middleName;
        private String url;
    }

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties (ignoreUnknown = true)
    public static class Category {
        private Integer id;
        private String slug;
        private String title;
        private String url;
    }

    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties (ignoreUnknown = true)
    public static class NForM {
        private Integer m;
        private Integer n;

    }
}
