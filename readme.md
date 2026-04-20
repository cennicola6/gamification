# Lab Report

**Student name:** Nicola Chen  
**Lab:** 2

---

## Activities Completed

- Replicated what was done during the lab, by strictly following what the professor has done:
  - implementation of ShipmentAPI
  - CSVReader
  - ChinaTaxes
  - BrazilTaxes
- Implemented ItalyTaxes
    

---

## Problems and Incomplete Activities

[In case you did not finish something or have problems, state it here. In case you have no problems, just put NONE.]

---

## AI Usage Declaration

I used AI to find a way to read the XML elements if there are no tags in the child elements, but instead attributes.  
Example with tags in child elements:
```xml
<catalog>
    <item id="1">
        <name>Laptop</name>
        <price>999.99</price>
    </item>
    <item id="2">
        <name>Mouse</name>
        <price>29.99</price>
    </item>
</catalog>
```
Structure in my case:
```xml
<shipments>
  <shipment product="coffee" type="FOOD" amount="1000" individualprice="5" shipmentPrice="500" country="Brazil"/>
</shipments>
```
I also used AI to generate test cases to speed up the process, but I made sure to not pass the method code that needs to be tested to generate them, but just the method description and the `Shipment` class, in order to avoid generating test that automatically pass, given the methods.

---

## Additional Comments

[If you have any additional observations or considerations about the lab, you can express them here]

---

## Points Claimed

[Put here TOTAL points you claim for the activities you did — when you did optional activities, also specify how much you are claiming for each one]