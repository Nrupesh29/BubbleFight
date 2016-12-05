# BubbleFight

[![Stories in Ready](https://badge.waffle.io/Nrupesh29/CMPE-202-Team-Project.svg?label=ready&title=Ready)](http://waffle.io/Nrupesh29/CMPE-202-Team-Project) [![Stories in In Development](https://badge.waffle.io/Nrupesh29/CMPE-202-Team-Project.svg?label=in%20progress&title=In%20Progress)](http://waffle.io/Nrupesh29/CMPE-202-Team-Project) [![Stories in In Testing](https://badge.waffle.io/Nrupesh29/CMPE-202-Team-Project.svg?label=test&title=In%20Testing)](http://waffle.io/Nrupesh29/CMPE-202-Team-Project) [![Stories in In Review](https://badge.waffle.io/Nrupesh29/CMPE-202-Team-Project.svg?label=review&title=In%20Review)](http://waffle.io/Nrupesh29/CMPE-202-Team-Project) [![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/Nrupesh29/CMPE-202-Team-Project/blob/master/LICENSE.md) [![GitHub issues](https://img.shields.io/badge/issues-4%20open-green.svg)](https://github.com/Nrupesh29/CMPE-202-Team-Project/issues?q=is%3Aopen+is%3Aissue) [![GitHub closed issues](https://img.shields.io/badge/issues-39%20closed-red.svg)](https://github.com/Nrupesh29/CMPE-202-Team-Project/issues?q=is%3Aissue+is%3Aclosed)

CS Unplugged is a collection of free learning activities that teach Computer Science through engaging games and puzzles. We are presenting a game **_BubbleFight_** which will introduce players to computational thinking through Binary Numbers. It is a multiplayer game where players will be given a binary equation and they need to solve the equation and find the decimal equivalent for the answer. Players will play as birds in the game who need to burst the correct answer bubble. Game has a set of rules which add to the competitive nature of game.

<img src="http://nrupeshpatel.com/CMPE202/GitHub/Images/GameBanner.png">

## Project Deliverables
[UI Wireframes] (Diagrams/UI Wireframes) <br/>
[Sequence Diagram] (Diagrams/Sequence Diagram)<br/>
[Activity Diagram] (Diagrams/Activity Diagrams)<br/>
[Web UI](WebUI)

## Installation
### AWS Elastic Beanstalk Installation
1. Sign in to [AWS Console] (https://aws.amazon.com/)
2. Select Elastic Beanstalk.
3. Click Create new application.
4. Enter application name and description.
5. Click create new environment.
6. Select Web server environment in Environment tier.
7. Choose PHP in Platform.
8. Select upload your code in Application Code option.
9. Download the [Backend API] (Backend API) folder from the repository and upload it.
10. Click Create Environment.

### MySQL Database Connection with EBS
1. Open the [RDS Console](https://console.aws.amazon.com/rds).
2. Click Instances and select Launch DB Instance.
3. Select MySQL.
4. Select Dev/Test for Free Tier Usage.
5. Enter following details for Instance Specifications
    * **DB Engine Version** - `5.6.27`
    * **DB Instance Class** - `db.t2.micro`
6. Enter following details for Settings
    * **DB Instance Identifier** - `{your_instance_name}`
    * **Master Username** - `{your_master_username}`
    * **Master Password** - `{your_master_password}`
7. Enter following details for Network & Security
    * **VPC** - Default VPC
    * **Publicly Accessible** - Yes
    * **VPC Security Group(s)** - Create new Security Group
8. Enter Database Name and choose Launch DB Instance
9. Choose the arrow next to the entry for your DB instance to expand the view.
10. Choose the Details tab.
11. In the Security and Network section, the security group associated with the DB instance is shown. Open the link to view the security group in the Amazon EC2 console.
12. In the security group details, choose the Inbound tab.
13. Choose Edit.
14. Choose Add Rule.
15. For Type, choose `MYSQL/Aurora`.
16. For Source, choose Custom IP, and then type the group ID of the security group.
17. Choose Save.
18. Open the [Elastic Beanstalk console] (https://console.aws.amazon.com/elasticbeanstalk).
19. Navigate to the management console for your environment.
20. Choose Configuration.
21. Choose Instances.
22. For EC2 security groups, type a comma after the name of the auto-generated security group followed by the name of the RDS DB instance's security group. By default, the RDS console creates a security group called `rds-launch-wizard`.
23. Choose Apply.
24. Read the warning, and then choose Save.
25. Choose Software Configuration.
26. In the Environment Properties section, define the following:
    * **RDS_DB_NAME** – The DB Name shown in the Amazon RDS console.
    * **RDS_HOSTNAME** – The Endpoint of the DB instance shown in the Amazon RDS console.
    * **RDS_PORT** – The Port shown in the Amazon RDS console.
    * **RDS_USERNAME** – The Master Username that you entered when you added the database to your environment.
    * **RDS_PASSWORD** – The Master Password that you entered when you added the database to your environment.
27. Choose Apply.

### Creating Database Tables
1. Download MySQL Workbench and connect to DB Instance using Endpoint.
2. Go to [MySQL Database] (Cloud Backend/MySQL Database) folder in repository and download the `tables.sql` file.
3. Execute the `tables.sql` script after selecting the database.

## Contributing

1. Search previous suggestions before making a new one, as your's may be a duplicate.
1. Create an issue and describe your idea.
2. [Fork it] (https://github.com/Nrupesh29/CMPE-202-Team-Project/fork)
3. Create a new branch for your feature (`git checkout -b my-new-feature`)
4. Commit the changes (`git commit -am 'Add some feature'`)
5. Publish the branch (`git push origin my-new-feature`)
6. Create a new Pull Request
7. Done!

Thank you for your suggestions!

## Credits

Graphics - [Freepik] (http://www.freepik.com/) <br/>
Learning Activity Concept - [CS Unplugged] (http://csunplugged.org/)

## Developement Lifecycle Charts
### KanBan Flow Diagram (Phase 1)
<img src="http://nrupeshpatel.com/CMPE202/GitHub/Images/KanBan%20Flow%20Diagram.png">
### Scrum Burndown Chart (Phase 2)
<img src="http://nrupeshpatel.com/CMPE202/GitHub/Images/Scrum%20Burndown%20Chart.png">

## License

BubbleFight is released under the [MIT License](https://github.com/Nrupesh29/CMPE-202-Team-Project/blob/master/LICENSE.md).

## KnightRiders Team

| [![Nrupesh Patel](https://avatars.githubusercontent.com/nrupesh29?s=100)<br /><sub>Nrupesh Patel<br />CMPE 202 - 03</sub>](https://github.com/Nrupesh29)<br /> | [![Aditi Shetty](https://avatars.githubusercontent.com/shettyaditi?s=100)<br /><sub>Aditi Shetty<br />CMPE 202 - 04</sub>](https://github.com/shettyAditi)<br /> | [![Ravi Gupta](https://avatars.githubusercontent.com/ravibgupta?s=100)<br /><sub>Ravi Gupta<br />CMPE 202 - 03</sub>](https://github.com/ravibgupta)<br />| [![Nam Phan](https://avatars.githubusercontent.com/mostman47?s=100)<br /><sub>Nam Phan<br />CMPE 202 - 03</sub>](https://github.com/mostman47)<br />|
| :---: | :---: | :---: | :---: |
