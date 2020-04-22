# Serialization and API's in Java

---

## Modern Applications Publish API's

- Can be used exclusively by front-ends
- Provide JSON serialization of data

---

## HTML is Just a Human-friendly Data Format

- In the context of our database applications, we use HTML to present the end user with data
- HTML brings structure to the data
- We use CSS and web browsers to make that format human-friendly

---

## JSON is Machine-friendly Data Format

- JSON allows us to exchange data with third parties in a consistent manner
- We translate Java objects into a more generic translation (JSON)
- We call this translation **serialization**

---

## Namespacing Our Endpoints

- Conventionally, we place our API routes at `/api/v1/widgets`
- We namespace all API endpoints to indicate that we'll be presenting machine friendly formats
- Often, we have a different set of authentication and authorization rules for API endpoints
- We version our endpoints so that we can later support legacy users when we publish new versions of the API

---

## Our Metaphor for Today

Wines - we're building a Wine review website

A wine:

- Is red or white
- Has a varietal (Pinot, Merlot, Cabernet, etc)
- Has a volume
- Corked or Screw top
- Has a geographic origin

---

## Spring Requires a Different Controller Name

If we have a standard HTML / HTTP controller called `WinesController`, we cannot have another class with the same name, even if it's in a different package / namespace.

- Follow the convention of `WinesApiController` or `<Plural form of Noun>ApiController`
- Place the controller in a nested `api` namespace to keep all API controllers organized

---

## Straight-from-table Serialization

```json
[
  {
    "id": 1,
    "brandName": "Oyster Bay Chardonnay",
    "winery": "Oyster Bay",
    "variety": "Chardonnay",
    "price": 11,
    "isCorked": false,
    "originCity": "Oyster Bay",
    "originProvince": "Marlborough",
    "originCountry": "New Zealand",
    "volumeInMl": 750
  }
]
```

---

## Limitations of Default Serialization

- Distinction between how we persist information and how we present information
- IE, metric vs. standard measurement of volume
- IE, Boolean or enum for the type of top?

---

## Enter the Data Transformation Object (DTO)

- We often _can't_ directly serialize database records
- An intermediary is necessary
- In Java, we refer to this intermediary as a **d**ata **t**ransfer **o**bject

---

## Ugly DTOs

```java
public class WineDTO {
  private Integer id;
  private String brandName;
  private String winery;
  private String variety;
  private Integer price;
  private Boolean bottleTop;
  private String originCity;
  private String originProvince;
  private String originCountry;
  private Integer volumeInMl;
}
```

---

## Translating from the Model to the DTO

```java
public static WineDTO fromWine(Wine wine) {
  WineDTO dto = new WineDTO();
  dto.setBrandName(wine.getBrandName());
  dto.setWinery(wine.getWinery());
  dto.setVariety(wine.getVariety());
  dto.setPrice(wine.getPrice());
  //...
  return dto
}
```

---

## Yuck! Enter MapStruct

- Like Lombok, but for mapping Entities with DTO's
- We define a `Mapper` interface to translate

---

## Making Our DTO More Functional - Bottle Top Enum

```java
public void setIsCorked(Boolean isCorked) {
  if(isCorked) {
    bottleTop = "cork";
  }
  else {
    bottleTop = "screwtop";
  }
}
```

---

## Making Our DTO More Functional - Bottle Top Enum

```java
public double getVolumeInOz() {
  return volumeInMl * 0.033814;
}
```

---

## Creating Our Mapper

```java
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface WineMapper {
  WineDTO wineToWineDTO(Wine wine);
  Iterable<WineDTO> winesToWineDTOs(Iterable<Wine> wines);
}
```

---

## Our New Controller Action

```java
@GetMapping
public Iterable<WineDTO> getList() {
  return wineMapper.winesToWineDTOs(wineRepository.findAll());
}
```

- Remember: our controller should be pretty dumb when it comes to business logic
- Therefore, we need a service object

---

## Enter Service Objects

```java
@Service
public class WineApiService {
  @Autowired
  private WineRepository wineRepo;

  @Autowired
  private WineMapper wineMapper;

  public Iterable<WineDTO> findAll() {
    return wineMapper.winesToWineDTOs(wineRepo.findAll());
  }
}
```

---

## Updated and Improved Controller

```java
@RestController
@RequestMapping("/api/v1/wines")
public class WinesApiController {
  @Autowired
  private WineApiService wineApiService;

  @GetMapping
  public Iterable<WineDTO> getList() {
    return wineApiService.findAll();
  }
```
