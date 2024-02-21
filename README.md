 # <p align="center"> 🎮OrderAttack🎮 </p>
 ##  <p align="center"> 🔔 1.Introduction 🔔  </p>
##### In Korea, recently, seniors aged 50 and above have been facing difficulties in using digital devices for placing orders. This digital alienation is leading to an information gap, which we define as an inequality. Our team has planned and developed an IT ordering practice app specifically designed for Korean seniors to address this issue.

### 💡Motivation
#### 1️⃣ The digital information gap in Korea was selected as an inequality to be solved with a solution. 
According to the results of the ITU's 2017 ICT IDI announcement,  the level of informatization in Korea is very high, so the information gap is larger than in other countries. In an environment where digital transformation is accelerating, the digital information gap is an inequality that harms living a happy life. We felt that our solution was needed to solve this.

#### 2️⃣Digital gap of seniors is a common problem in Germany, Japan, and Korea. 
Since it is not just a problem in Korea, we decided that it could be helpful to more people, so we chose it as a task to solve the digital gap.

### 💡Problem
 #### 1️⃣ Many restaurants in Korea have set up unmanned kiosks, making it difficult for seniors to live their daily lives.
 If seniors who are unfamiliar with kiosks use them to order, the ordering time will be longer. This fact, the people behind seniors are waiting for them, brings to seniors psychological pressure. Due to this situation, seniors may be reluctant to visit offline stores itself. 

  #### 2️⃣Seniors are having difficulty in cultural life using digital devices. 
  The lack of information on how to book movies through mobile applications causes seniors to be unable to book the desired seats or to give up watching popular movies. This shows the phenomenon of depriving seniors of cultural opportunity just because they are inexperienced in using digital devices.
  
### 💡Goal
<img width="150" alt="target" src="https://github.com/leeinsunny/OrderAttack/blob/main/3.png"><img width="150" alt="target" src="https://github.com/leeinsunny/OrderAttack/blob/main/4.png"><img width="150" alt="target" src="https://github.com/leeinsunny/OrderAttack/blob/main/10.png">
  <br> We planned a solution using smartphone applications to solve these problems and reduce the seniors' fear of using digital devices. This solution allows seniors to learn and practice functions such as kiosk ordering, movie booking, and bus reservation, and we introduced a reward system to increase their accomplishment  with these exercises.


### 💡Target
#### Our target is 🎎seniors in their 50s or older🎎 in Korea. 
According to the graph of digital problem-solving proficiency by age in major OECD member countries, the problem-solving proficiency of 16-25 years old in Korea was over 60%, while that of 55-65 years old was under 5%. Based on these data, it was determined that the digital problem-solving ability of the elderly in Korea should be improved, so we select the target.

---

## <p align="center"> 🔔 2. Explanation of "OrderAttack" 🔔  </p>
### 🍔 Ordering by Kiosk Step
<table style="width: 40%;">
  <tr>
    <td style="text-align: center;">
      <img src="https://github.com/GDSC-TEAM-1-PathPal/.github/assets/68684425/f18cc049-3d45-4e47-a6c3-b8ea249c13c7" alt="Image 1" style="width: 40%;">
      <p>Kiosk Step</p>
    </td>
  </tr>
</table>

#### You will practice ordering food using a kiosk at a fast food restaurant. Real photo verification will help you improve your IT ordering skills.

### 📽Booking a Movie Step
<table style="width: 40%;">
  <tr>
    <td style="text-align: center;">
      <img src="https://github.com/GDSC-TEAM-1-PathPal/.github/assets/68684425/f18cc049-3d45-4e47-a6c3-b8ea249c13c7" alt="Image 1" style="width: 40%;">
      <p>Movie Step</p>
    </td>
  </tr>
</table>

#### You will practice using the application to book tickets for a movie that is currently playing.

### 👛 Get Rewards : Wallet

<table style="width: 100%;">
  <tr>
    <td style="text-align: center;">
      <img src="https://github.com/GDSC-TEAM-1-PathPal/.github/assets/68684425/f18cc049-3d45-4e47-a6c3-b8ea249c13c7" alt="Image 1" style="width: 100%;">
      <p>Wallet in Kiosk 1st step</p>
    </td>
    <td style="text-align: center;">
      <img src="https://github.com/GDSC-TEAM-1-PathPal/.github/assets/68684425/f18cc049-3d45-4e47-a6c3-b8ea249c13c7" alt="Image 1" style="width: 100%;">
      <p>Wallet in Movie 1st step</p>
    </td>
    <td style="text-align: center;">
      <img src="https://github.com/GDSC-TEAM-1-PathPal/.github/assets/68684425/f18cc049-3d45-4e47-a6c3-b8ea249c13c7" alt="Image 1" style="width: 100%;">
      <p>Wallet in Kiosk Bonus step</p>
    </td>
  </tr>
</table>

#### As you progress through each level, you'll be able to change your wallet as a reward for your skills. Build your wallet with a sense of accomplishment.
---

## <p align="center"> 🔔 3. Architecture 🔔  </p>
<img width="1032" alt="오더어택 아키텍쳐" src="https://github.com/leeinsunny/orderattack_photo/blob/main/architecture%20(1).png">

 - FrontEnd
   - The app was developed using  Android Studio, Kortlin, and Pigma.
   - The Google Maps platform was used to utilize the map API.

 - BackEnd
    - Firebase was used for app data storage and management.
    - Google login was facilitated through the use of Authentication.
    - Firestore was used to manage user and other data.      
 - AI Model
   - Tesseract replaces letters with text in photos taken from the gallery  
   - Google Bert recognizes the text that Tesseract has replaced.

---
## <p align="center"> 🔔 4. Execution Method 🔔  </p>
### For Android User
1. You can download language file => [Click Here!](https://drive.google.com/file/d/1vmn5PTXRt147OB2GA3CgqgqTOmZucqq-/view?usp=sharing)
2. Android AVD size=1440*3040
3. You have to give permission for INTERNET & Location
---


