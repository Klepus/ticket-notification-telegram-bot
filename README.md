[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f5941b57b1a443c19efbf56ec3009706)](https://app.codacy.com/gh/Klepus/ticket-notification-telegram-bot?utm_source=github.com&utm_medium=referral&utm_content=Klepus/ticket-notification-telegram-bot&utm_campaign=Badge_Grade_Settings)

## Ticket notification telegram bot
Telegram bot for RZD ticket changes notifications

# Technological stack
- SpringBoot as a skeleton framework
- Spring Scheduler as a task manager
- MySQL database as a database for saving user and subscription info
- Flyway database migration tool
- Telegram-bot SpringBoot starter
- Spring Data starter
- Unirest - lib for working with REST calls

## Deployment
Deployment process:
to deploy application, switch to needed branch and run bash script:

$ bash start.sh ${bot_username} ${bot_token}

Required software:
- terminal for running bash scripts
- docker
- docker-compose

## Release Notes
Can be found in [RELEASE_NOTES](RELEASE_NOTES.md).

## Authors
* Aleksey Klepinin - [Telegram](https://t.me/klepus)

## Contributing
Please, follow [Contributing](CONTRIBUTING.md) page.

## Code of Conduct
Please, follow [Code of Conduct](CODE_OF_CONDUCT.md) page.

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details
