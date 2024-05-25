# Tomato Game JAVA

Tomato Game is an engaging and fun game developed in Java. The project is structured into several key components including game engines, a game server, GUI components, and a database.

## Project Structure

The project is organized into the following main parts:

### Engines
- **game**: Core game logic and mechanics.
- **gameengine**: Manages the game state and coordinates between different game components.
- **gameserver**: Handles server-side operations and multiplayer functionalities. This component also connects to the external API to fetch game-related data.

### Peripherals
- **front**: Frontend components and initial entry points.
- **gameGUI**: Graphical User Interface for the game.
- **Instructions**: Displays instructions and guides for players.
- **leaderboard**: Manages and displays the leaderboard.
- **login**: Handles user login operations.
- **loginData**: Manages login data and authentication.
- **LoginGUI**: GUI for the login process.
- **Signin**: Handles user sign-in and registration.

### Database
- **Database Connection**: Uses JDBC to connect to the MySQL database at `jdbc:mysql://localhost:3306/gamedb`.

### External API
- **TomatoAPI**: The game server engine connects to an external API to fetch game data. The API endpoint is:
  ```
  https://marcconrad.com/uob/tomato/api.php?out=csv&base64=yes
  ```

## Getting Started

To get a copy of the project up and running on your local machine, follow these steps:

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL database
- Maven or Gradle for dependency management (optional but recommended)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/tomato-game.git
   cd tomato-game
   ```

2. **Set up the database**
   - Ensure MySQL is installed and running.
   - Create the database schema:
     ```sql
     CREATE DATABASE gamedb;
     ```
   - Update the database connection parameters in your configuration files if necessary.

3. **Build the project**
   If you're using Maven:
   ```bash
   mvn clean install
   ```

   If you're using Gradle:
   ```bash
   gradle build
   ```

4. **Run the game**
   ```bash
   java -cp target/tomato-game.jar com.yourpackage.MainClass
   ```

## Usage

- Launch the game and navigate through the login or sign-in processes.
- Follow the instructions provided within the game.
- The game server will fetch additional game data from the external TomatoAPI.
- Enjoy playing Tomato Game and try to top the leaderboard!

## Contributing

We welcome contributions! If you'd like to contribute, please fork the repository and use a feature branch. Pull requests are warmly welcome.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Acknowledgements

- Special thanks to all contributors and supporters.
- Libraries and tools used in this project.

---

Happy Gaming!
```

This updated `README.md` file now includes information about the external `tomatoapi` and its connection to the `gameserver` engine, ensuring users and developers are aware of how the game fetches additional data.
