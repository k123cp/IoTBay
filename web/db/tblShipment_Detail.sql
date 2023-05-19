/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  John
 * Created: 18 May 2023
 */

CREATE TABLE tblShipment_Detail (
    Shipment_Detail_ID int GENERATED ALWAYS AS IDENTITY NOT NULL,
    Address_ID int NOT NULL,
    Delivery_Fee DOUBLE NOT NULL,
    Delivery_Instructions VARCHAR(100),
    Delivery_Date DATE NOT NULL,
    Delivery_Method VARCHAR(8) NOT NULL,
    PRIMARY KEY (Shipment_Detail_ID),
    FOREIGN KEY (Address_ID) REFERENCES tblAddress(Address_ID)  
);

INSERT INTO tblShipment_Detail (Address_ID, Delivery_Fee, Delivery_Instructions, Delivery_Date, Delivery_Method) VALUES
(1,10, null, '2023-2-16', 'standard'),
(1,10, 'buzzer is broken please call when you arrive', '2023-3-1', 'standard'),
(1,20, 'buzzer is broken please call when you arrive', '2023-3-20', 'express'),
(1,10, 'please ring buzzer when you arrive', '2023-3-20', 'standard'),
(1,20, null, '2023-4-27', 'express'),
(3,10, null, '2023-2-18', 'standard'),
(4,20, null, '2023-2-25', 'express'),
(5,10, null, '2023-4-5', 'standard'),
(6,20, null, '2023-5-27', 'express'),
(7,10, null, '2023-4-27', 'standard'),
(8,10, null, '2023-2-16', 'standard'),
(9,20, null, '2023-4-27', 'express'),
(10,10, null, '2023-4-27', 'standard'),
(11,20, null, '2023-4-27', 'express'),
(12,20, null, '2023-5-21', 'express'),
(14,20, null, '2023-3-7', 'express'),
(16,10, 'our apartment is located around the back of the building', '2023-2-18', 'standard'),
(17,10, null, '2023-3-1', 'standard'),
(18,20, null, '2023-2-6', 'express'),
(19,20, 'please leave the delivery with our doorman', '2023-4-27', 'express');