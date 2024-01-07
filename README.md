<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

### Part C:
- mainscreen.html: fixed the header, title  
  <pre>
  From
  Line 14 - < title > My Bicycle Shop  < /title >
  To
  Line 14 - < title > DoneFu Computer Shop < /title >
  
  From
  Line 19 - < title > Shop < /title>
  To
  Line 19 - < title > Computer Parts < /title>
  
    </pre>
### Part D:
- about.html: added title 'About' and with some paragraphs in detail, added 'Back to the main page' button that able to direct to mainscreen.html
- mainscreen.html: added 'About' button that able to direct to about.html
  <pre>
    Create - about.html
    < !DOCTYPE html >
    < html lang="en" xmlns:th="http://www.thymeleaf.org" >
    < head >
    < meta charset="UTF-8">

    < !-- Required meta tags -->
    < meta charset="utf-8" >
    < meta name="viewport" content="width=device-width, initial-scale=1" >

    < ! -- Bootstrap CSS -- >
    < link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" >
    < style >
        body {
            background: white;
            margin-top: 3rem;
            margin-left: 3rem;
            font-size: large;
        }
        p {
            margin-left: 2rem;
        }
    < /style >
    < title >About Us < /title >
    < /head >
    < body >
    < h1 > Welcome to DoneFu Computer < /h1 >
    < p >
        At our store, we're more than just a PC store; we're your destination for stepping into modern and high-tech.
        Our passion for footwear goes beyond trends – we believe in providing you with a curated selection of high-quality
        and affordable PC that not only complement your need but also make each step a statement.
    < /p >
    < h1 >Expertise and Excellence < /h1 >
    < p >
        With years of experience in the industry, our team of tech enthusiasts and experts is dedicated to curating a diverse selection of products that meet the highest standards of performance and reliability. We handpick each item in our inventory to ensure that our customers have access to the best and most trusted brands in the market.
    < /p >
    < p >
        Customer satisfaction is at the heart of everything we do. Our knowledgeable and friendly staff are here to assist you at every step, from product selection to after-sales support. We believe in building lasting relationships with our customers, and our commitment to service excellence sets us apart.
    < /p >
    < h1>Our Promise < /h1 >
    < p >
        We are not just a store; we are part of a vibrant community of tech enthusiasts. Join us for events, workshops, and product launches, where you can connect with like-minded individuals, learn about the latest trends, and get hands-on experience with cutting-edge technology.
    < /p >
    < p >
        Happy shopping!
    < /p >
    < a th:href="@{/mainscreen}" class="btn btn-primary btn-sm mb-3">Back To Main Screen < /a >

    < /body >
    < /html >
  </pre>

  <pre>
  Insert - mainscreen.html
    line 21     < a th:href="@{/about}" class="btn btn-primary btn-sm mb-3">About Our Store < /a >
  </pre>

  <pre>
    Create - AboutController
    
  
  @Controller
  public class AboutController {
  @GetMapping("/about")
  public String aboutPage(){
  return "about";
  }
  }
  </pre>
### Part E:
- BootStrapData.java: added an if statement to check count of parts and products to check if there is inventory already there, and update the products and parts
<pre>
  Insert - BootStrapData.java
if (partRepository.count() == 0 && productRepository.count() == 0) {
            // PARTS
            OutsourcedPart o1 = new OutsourcedPart();
            o1.setCompanyName("MSI");
            o1.setName("MSI MPG B550 GAMING PLUS");
            o1.setInv(5);
            o1.setPrice(149.0);
            o1.setId(100L);
            o1.setMinValue(1);
            o1.setMaxValue(20);
            outsourcedPartRepository.save(o1);
            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("NVIDIA");
            o2.setName("Founders Edition NVIDIA GeForce RTX 4090 24GB GDDR6X Graphics Card");
            o2.setInv(15);
            o2.setPrice(2299.99);
            o2.setId(101L);
            o2.setMinValue(1);
            o2.setMaxValue(20);
            outsourcedPartRepository.save(o2);
            OutsourcedPart o3 = new OutsourcedPart();
            o3.setCompanyName("Corsair");
            o3.setName("Corsair Vengeance RGB Pro 32GB (2x16GB) 2666");
            o3.setInv(7);
            o3.setPrice(72.99);
            o3.setId(102L);
            o3.setMinValue(1);
            o3.setMaxValue(20);
            outsourcedPartRepository.save(o3);
            OutsourcedPart o4 = new OutsourcedPart();
            o4.setCompanyName("Thermaltake");
            o4.setName("Thermaltake Smart 700W ATX 80 Plus Power Supply");
            o4.setInv(12);
            o4.setPrice(54.99);
            o4.setId(103L);
            o4.setMinValue(1);
            o4.setMaxValue(20);
            outsourcedPartRepository.save(o4);
            OutsourcedPart o5 = new OutsourcedPart();
            o5.setCompanyName("Asus");
            o5.setName("Asus ROG Ryujin II 240 ARGB Cooling Fan/Pump");
            o5.setInv(6);
            o5.setPrice(299.69);
            o5.setId(104L);
            o5.setMinValue(1);
            o5.setMaxValue(20);
            outsourcedPartRepository.save(o5);

            // PRODUCTS
            Product RDY_Y60 = new Product("RDY Y60 002", 1899, 5);
            Product RDY_Y61 = new Product("Gaming RDY SLMBG221", 1299, 15);
            Product RDY_Y62 = new Product("RDY Trace 7MP 001", 1599, 7);
            Product RDY_Y63 = new Product("RDY Y40P 001", 1099, 10);
            Product RDY_Y64 = new Product("Creator RDY Y40BG201", 3000, 3);

            productRepository.save(RDY_Y60);
            productRepository.save(RDY_Y61);
            productRepository.save(RDY_Y62);
            productRepository.save(RDY_Y63);
            productRepository.save(RDY_Y64);
        }
</pre>
### Part F:
- mainscreen.html: added 'Buy Now' button and it decreases the inventory of that product by one, able to display a message that indicates the success or failure of the purchase
<pre>
  < form th:action="@{/buyProduct}" method="post" >
      < input type="hidden" name="productID" th:value="${tempProduct.id}" />
      < button type="submit" class="btn btn-primary btn-sm mb-3" onclick="return confirm('Are you sure you want to buy this product?')">Buy Now</button>
  < /form>
</pre>
- BuyNowProductController: able to map to the button from mainscreen.html
<pre>
Create BuyNowProductController.java

@Controller
public class BuyNowProductController {

    private final ProductRepository productRepository;
    @Autowired
    public BuyNowProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam Long productID) {
        Optional<Product> optionalProduct = productRepository.findById(productID);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (product.getInv() > 0) {
                // Decrease inventory by 1
                product.setInv(product.getInv() - 1);
                productRepository.save(product);

                // Redirect to success page
                return "redirect:/purchaseSuccess";
            } else {
                // Redirect to error page (out of stock)
                return "redirect:/purchaseError";
            }
        } else {
            // Redirect to error page (product not found)
            return "redirect:/purchaseError";
        }
    }

    @GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess"; // Create purchaseSuccess.html
    }

    @GetMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError"; // Create purchaseError.html
    }
}
</pre>
- purchaseSuccess.html: display a success purchase message
<pre>
  Create purchaseSuccess.html
  <!DOCTYPE html>
  < html lang="en" xmlns:th="http://www.thymeleaf.org" >
  < head >
    < meta charset="UTF-8" >

    < !-- Required meta tags -- >
    < meta charset="utf-8" >
    < meta name="viewport" content="width=device-width, initial-scale=1" >

    < !-- Bootstrap CSS -- >
    < link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" >
    < style >
        body {
            background: white;
            margin-top: 3rem;
            margin-left: 3rem;
            font-size: xx-large;

        }
        p {
            margin-left: 2rem;
        }
    < /style >
    < title>Purchase Success < /title >
< /head >
< body >
    < div class="all-classes-container" >
        < p >Your purchase was successful. Thank you for supporting us < /p >
        < a th:href="@{/mainscreen}" class="btn btn-primary btn-sm mb-3">Back To Main Screen < /a >
    < /div >
< /body >
< /html >
</pre>
- purchaseError.html: display a failure purchase message
<pre>
Create purchaseError.html

< !DOCTYPE html >
< html lang="en" xmlns:th="http://www.thymeleaf.org" >
< head >
    < meta charset="UTF-8" >

    < !-- Required meta tags -- >
    < meta charset="utf-8" >
    < meta name="viewport" content="width=device-width, initial-scale=1" >

    < !-- Bootstrap CSS -- >
    < link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" >
    < style >
        body {
            background: white;
            margin-top: 3rem;
            margin-left: 3rem;
            font-size: large;
        }
        p {
            margin-left: 2rem;
        }
    < /style >
    < title>Purchase Success < /title >
< /head >
< body >
< div class="all-classes-container" >
    < p >Your purchase was unsuccessful. Please go back to the main screen and double check again. < /p >
    < a th:href="@{/mainscreen}" class="btn btn-primary btn-sm mb-3">Back To Main Screen < /a >
 < /div >
< /body >
< /html >
</pre>
### Part G:
- Part.java: initialized max and min value, added a new constructor that allows max and min value, check if it meets the requirements, added setter and getter for both
<pre>
    private int minValue;


    private int maxValue;

    public Part(long id, String name, double price, int inv, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minValue = min;
        this.maxValue = max;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }
</pre>
- AddInhousePartController: display the message
<pre>
 @PostMapping("/showFormAddInPart")
    public String submitForm(
            @Valid @ModelAttribute("inhousepart") InhousePart part,
            BindingResult theBindingResult,
            Model theModel) {
        theModel.addAttribute("inhousepart", part);
        if (theBindingResult.hasErrors()) {
            return "InhousePartForm";
        }
        else {
            if (!part.isInvvalid()) {
                theBindingResult.rejectValue("inv", "Wrong Inv", "Inventory must in range of min and max");
                if (part.getInv() < part.getMinValue()) {
                    theBindingResult.rejectValue("inv", "SmallerThanMinInv", "Inventory needs to be bigger than minimum");
                } else if (part.getInv() > part.getMaxValue()) {
                    theBindingResult.rejectValue("inv", "BiggerThanMaxInv", "Inventory needs to be smaller than maximum");
                }
                return "InhousePartForm";
            }
            InhousePartService inhouseRepo = context.getBean(InhousePartServiceImpl.class);
            InhousePart inPart = inhouseRepo.findById((int) part.getId());
            if (inPart != null) {
                part.setProducts(inPart.getProducts());
            }
            inhouseRepo.save(part);
            return "confirmationaddpart";
        }
    }
</pre>
- AddOutsourcedPartController: add text input for max and min
<pre>
  Insert line 30
< p > < label >
        < input type="text" th:field="*{minValue}" placeholder="Min Inventory" class="form-control mb-4 col-4" />
    < /label > < /p >
    < p > < label >
        < input type="text" th:field="*{maxValue}" placeholder="Max Inventory" class="form-control mb-4 col-4" />
    < /label > < /p >
</pre>
- Renamed the spring-boot-h2-db to spring_d287 in application.properties
<pre>
 Change  application.properties
        spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
        TO
        spring.datasource.url=jdbc:h2:file:~/src/main/resources/spring_d287
</pre>
- Part.java: created a new method to check if an inventory is valid
<pre>
Insert a new method
public boolean isInvvalid () {
        return inv >= minValue && inv <= maxValue ? true : false;
    }
</pre>
### Part H:
- AddInhousePartController: added if else statements to display error messages when adding/updating parts if the inventory is less/more than the min/max number of parts
<pre>
Insert line 47
if (!part.isInvvalid()) {
                theBindingResult.rejectValue("inv", "Wrong Inv", "Inventory must in range of min and max");
                if (part.getInv() < part.getMinValue()) {
                    theBindingResult.rejectValue("inv", "SmallerThanMinInv", "Inventory needs to be bigger than minimum");
                } else if (part.getInv() > part.getMaxValue()) {
                    theBindingResult.rejectValue("inv", "BiggerThanMaxInv", "Inventory needs to be smaller than maximum");
                }
                return "InhousePartForm";
            }
</pre>
- AddOutsourcedPartController: added if else statements to display error messages when adding/updating parts if the inventory is less/more than the min/max number of parts
<pre>
Insert line 45
if (!part.isInvvalid()) {
                bindingResult.rejectValue("inv", "Wrong Inv", "Inventory must in range of min and max");
                if (part.getInv() < part.getMinValue()) {
                    bindingResult.rejectValue("inv", "SmallerThanMinInv", "Inventory needs to be bigger than minimum");
                } else if (part.getInv() > part.getMaxValue()) {
                    bindingResult.rejectValue("inv", "BiggerThanMaxInv", "Inventory needs to be smaller than maximum");
                }
                return "OutsourcedPartForm";
            }
</pre>
### Part I:
- PartTest.java: added 4 unit tests for min and max
<pre>
Insert line 160
    @Test
    void testInhouseMin() {
        int minInv = 1;
        partIn.setInv(minInv);
        assertEquals(minInv, partIn.getInv());
    }

    @Test
    void testInhouseMax() {
        int maxInv = 30;
        partIn.setInv(maxInv);
        assertEquals(maxInv, partIn.getInv());
    }

    @Test
    void testOutsourcedMin() {
        int minInv = 1;
        partOut.setInv(minInv);
        assertEquals(minInv, partOut.getInv());
    }

    @Test
    void testOutsourcedMax() {
        int maxInv = 30;
        partOut.setInv(maxInv);
        assertEquals(maxInv, partOut.getInv());
    }
</pre>
- mainscreen.html: added min and max columns into the table
<pre>
< td th:text="${tempPart.minValue}">1 < /td >
< td th:text="${tempPart.maxValue}">1 < /td >
</pre>
### Part J:
