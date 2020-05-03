# GULI MALL

## Environment
- mysql config
```properties
[client]
default-character-set=utf8

[mysql]
default-character-set=utf8

[mysqld]
init_connect='SET collation_connection = utf8_unicode_ci'
init_connect='SET NAMES utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
skip-name-resolve
```
```shell script
docker run -p 3306:3306 --name mysql -v ~/dev/data/mysql/log:/var/log/mysql 
-v ~/dev/data/mysql/data/:/var/lib/mysql 
-v ~/dev/data/mysql/conf/:/etc/mysql 
-e MYSQL_ROOT_PASSWORD=password -d mysql:5.7
```


## Validation
- validation different for addgroup and updategroup
```java
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @NotNull(message = "must be not null for update", groups = {UpdateGroup.class})
    @Null(message = "must be null for creation", groups = {AddGroup.class})
    private Long brandId;

    @NotBlank(message = "must have brand name", groups = {UpdateGroup.class, AddGroup.class})
    private String name;

    @NotEmpty(groups = {AddGroup.class})
    @URL(message = "url must be valid url address", groups = {UpdateGroup.class, AddGroup.class})
    private String logo;

    private String descript;

    private Integer showStatus;

    @NotEmpty(groups = {AddGroup.class})
    @Pattern(regexp = "/^[a-zA-Z]$/", message = "first char must be letter", groups = {UpdateGroup.class, AddGroup.class})
    private String firstLetter;

    @NotNull(groups = {AddGroup.class})
    @Min(value = 0, message = "sort must be greater than 0")
    private Integer sort;

}

@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand) {

        brandService.save(brand);
        return R.ok();
    }
}

@RestControllerAdvice(basePackages = "com.bp.gulimall.product.controller")
@Slf4j
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {

        log.error("validation exception{}, execption type:{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(item -> item.getField(), item -> item.getDefaultMessage()));
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data", map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable t) {
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(), BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }
}
```
- customized validation annotation and validator
    + validation annotation
    + add ValidationMessages.properties for validation message
    + validator class implements ConstraintValidator
```java
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ListValue(vals = {0, 1}, groups = {AddGroup.class})
    private Integer showStatus;
}

@Documented
@Constraint(validatedBy = {ListValueConstraintValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ListValue {

    String message() default "{com.bp.common.valid.ListValue.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int[] vals() default {};

}

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();
    @Override
    public void initialize(ListValue constraintAnnotation) {
        set = Arrays.stream(constraintAnnotation.vals()).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
```
```properties
com.bp.common.valid.ListValue.message = must be 0 or 1
```