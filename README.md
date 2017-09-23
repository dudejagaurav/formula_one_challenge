![alt text](http://cdn0.agoda.net/images/MVC/default/logo-agoda-mobile@2X.png "agoda")

Programming Exercise
===================

Congratulations, you have passed the first phase of our interview. 

On this second phase we are going to test your programming skills, so we have a exercise template writen in Java that you will need to complete. (you could easily change to a language of your preference)

Follow the instructions of the exam below, and produce the given results in any language of your preference. 

The solution should be complete and production ready. Please do not write just the core code algorithm, leaving out e.g. error handling.
Your code should be covered by unit tests.
Feel free to use any kind of unit test framework

The solution will be evaluated on following
parameters.
Object Oriented Design aspects of the solution.
Overall coding practices.
Working test cases of the solution.

You can use any build tool for the solution, and any of the existing test frameworks.
You may also include a brief explanation of your design and assumptions along with your code.

In a Formula-1 challenge, there are n teams numbered 1 to n. Each team has a car and a driver.

Car's specification are as follows:
- Top speed: (150 + 10 * i) km per hour
- Acceleration: (2 * i) meter per second square.
- Handling factor (hf) = 0.8
- Nitro : Increases the speed to double or top speed, whichever is less. Can be used only once.

Here i is the team number.

The cars line up for the race. The start line for (i + 1)th car is 200 * i meters behind the ith car.
All of them start at the same time and try to attain their top speed. A re-assessment of the positions is done every 2 seconds(So even if the car has crossed the finish line in between, you'll get to know after 2 seconds). During this assessment, each driver checks if there is any car within 10 meters of his car, his speed reduces to: hf * (speed at that moment). Also, if the driver notices that he is the last one on the race, he uses 'nitro'.

Taking the number of teams and length of track as the input, Calculate the final speeds and the corresponding completion times.




Good luck!

<br />

All material herein © 2005 – 2014 Agoda Company Pte. Ltd., All Rights Reserved.<br />
AGODA ® is a registered trademark of AGIP LLC, used under license by Agoda Company Pte. Ltd.<br />
Agoda is part ofPriceline (NASDAQ:PCLN)<br />





Approach/Solution
===================

Logic is quite simple here the only problem here is when HF factor Or  acceleration come into picture.


if the object has a constant acceleration, its average acceleration is the exact same value.
Average acceleration, measured in units of distance per time-squared
as assesment is done after 2 second there is boost in speed as car acceleration is constant

<Code>double distanceTraveled = this.getCurrentSpeed() + this.getAcceleration() * time * time / 2</Code>



<h3> Assesment</h3>

When ever assement is perfromed it is performed after 2 seconds.
 so we will get the nearest car and store into hash set
 so that no car will repeat again and finally apply hf over all cars.


<H3>To run project either run <Code>mvn clean install</Code> or <Code>mvn test </Code></H3>


