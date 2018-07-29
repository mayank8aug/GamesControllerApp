Instructions to get started:
1. Create an schema named as gamesdb in mysql.
2. Run this java application:
	GameController\src\main\java\com\games\GameControllerApplication.java
3. Go to the browser(preferably Chrome) and hit http://localhost:8181/homeNg.html

Functional behavior:
1. On arriving to homeNg.html, you will find an input box to search/filter games by their title and a grid containing all the games (sorted by title by default).
2. Clicking on any of the grid column header will sort the data based on that column data. Clicking again the same, will reverse the sorting order.
3. By default 10 records are shown per page along with the current page count and total pages. User can navigate to any page by entering the page number within the input box available on the grid bottom toolbar. Pagination is handled at server side.
4. Entering text in the top search input will start filtering the grid data based on the game title.
