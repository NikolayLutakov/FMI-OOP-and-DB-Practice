import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame
{
	Connection connection  = null;
	PreparedStatement statement = null;
	ResultSet result;
	int id = -1;
	
	//Author
	//-----------------------------------------------------------
	
	//Author Panel
	JPanel authorPanel = new JPanel();
	
	//Up Author Panel
	JPanel upAuthorPanel = new JPanel();
	
	
	//Id, FirstName, LastName, Email, Phone
	
	JLabel authorFirstName = new JLabel("First Name:", SwingConstants.CENTER);
	JLabel authorLastName = new JLabel("Last Name:" , SwingConstants.CENTER);
	JLabel authorEmail = new JLabel("Email:" , SwingConstants.CENTER);
	JLabel authorPhone = new JLabel("Phone:" , SwingConstants.CENTER);
	
	JTextField authorFirstNameField = new JTextField();
	JTextField authorLastNameField = new JTextField();
	JTextField authorEmailField = new JTextField();
	JTextField authorPhoneField = new JTextField();
	
	//Middle Author Panel
	JPanel midAuthorPanel = new JPanel();
	
	JButton createAuthorBtn = new JButton("Create Author");
	JButton deleteAuthorBtn = new JButton("Delete Author");
	JButton updateAuthorBtn = new JButton("Update Author");
	
	//Down Author Panel
	JPanel downAuthorPanel = new JPanel();
	JTable authorTable = new JTable();
	JScrollPane authorScroll = new JScrollPane(authorTable);
	
	
	
	
	//Book
	//-----------------------------------------------------------
	
	//Book Panel
	JPanel bookPanel = new JPanel();
	
	
	//Up Book Panel
	JPanel upBookPanel = new JPanel();
	
	JLabel bookTitle = new JLabel("Book Title:", SwingConstants.CENTER);
	JLabel bookGenre = new JLabel("Genre:" , SwingConstants.CENTER);
	JLabel bookPrice = new JLabel("Price:" , SwingConstants.CENTER);
	JLabel bookPages = new JLabel("Pages:" , SwingConstants.CENTER);
	JLabel bookPublishedOn = new JLabel("Published On:" , SwingConstants.CENTER);
	
	JTextField bookTitleField = new JTextField();
	JTextField bookGenreField = new JTextField();
	JTextField bookPriceField = new JTextField();
	JTextField bookPagesField = new JTextField();
	JTextField bookPublishedOnField = new JTextField();
	
	
	//Middle Book Panel
	JPanel midBookPanel = new JPanel();
	
	JButton createBookBtn = new JButton("Create Book");
	JButton deleteBookBtn = new JButton("Delete Book");
	JButton updateBookBtn = new JButton("Update Book");
	
	//Down Book Panel
	JPanel downBookPanel = new JPanel();
	
	JTable booksTable = new JTable();
	JScrollPane booksScroll = new JScrollPane(booksTable);
	
	
	
	//Add Book ToAuthor
	//-----------------------------------------------------------
	
	//Add Book To Author Panel
	JPanel authorBookPanel = new JPanel();
	
	
	
	//Up book to author panel
	
	JPanel upBookToAuthorPanel = new JPanel();
	JLabel authorsLabel = new JLabel("Select Author:", SwingConstants.CENTER);
	
	JComboBox<String> authorsCombo = new JComboBox<String>();
	
	
	//Middle book to author panel
	JPanel midBookToAuthorPanel = new JPanel();
	JLabel booksLabel = new JLabel("Select Book:" , SwingConstants.CENTER);
	JComboBox<String> booksCombo = new JComboBox<String>();
	
	//Down book to author panel
	
	
	JPanel downBookToAuthorPanel = new JPanel();
	JButton addBookToAuthorBtn = new JButton("Add Book to Author");
	JButton removeBookFromAuthorBtn = new JButton("Remove Book from Author");
	
	
	//Table book to author panel
	JPanel tableBookToAuthorPanel = new JPanel();
	
	JTable bookToAuthorTable = new JTable();
	JScrollPane bookToAuthorScroll = new JScrollPane(bookToAuthorTable);
	
	
	//Search panel
	JPanel searchBooksByTitlePanel = new JPanel();
	
	//Up Search Panel
	JPanel upSearchBooksByTitlePanel = new JPanel();
	JTextField input = new JTextField();
	JButton search = new JButton("Search");
	JButton refresh = new JButton("Refresh");
	
	//Down Search Panel
	JPanel downSearchBooksByTitlePanel = new JPanel();
	
	JTable searchResultTable = new JTable();

	
	//JScrollPane searchResultScroll = new JScrollPane(searchResultTable);
	JScrollPane searchResultScroll = new JScrollPane(searchResultTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	//Create tabs
	JTabbedPane tab = new JTabbedPane();
	
	public MainFrame()
	{
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Add Panels To Tab		
		tab.add("Author", authorPanel);
		tab.add("Book", bookPanel);
		tab.add("Add Book To Author", authorBookPanel);
		tab.add("Search Books by Title", searchBooksByTitlePanel);
		
		
		
		//Add Items To Up Author Panel
		upAuthorPanel.setLayout(new GridLayout(4, 2));
		upAuthorPanel.add(authorFirstName);
		upAuthorPanel.add(authorFirstNameField);
		upAuthorPanel.add(authorLastName);
		upAuthorPanel.add(authorLastNameField);
		upAuthorPanel.add(authorEmail);
		upAuthorPanel.add(authorEmailField);
		upAuthorPanel.add(authorPhone);
		upAuthorPanel.add(authorPhoneField);
		
		//Add Items To Middle Author Panel
		midAuthorPanel.setLayout(new FlowLayout());
		midAuthorPanel.add(createAuthorBtn);
		midAuthorPanel.add(deleteAuthorBtn);
		midAuthorPanel.add(updateAuthorBtn);
		
		//Add Items To Down Author Panel
		authorScroll.setPreferredSize(new Dimension(565, 170));
		downAuthorPanel.add(authorScroll);
		
		//Add Items To Author Panel
		authorPanel.setLayout(new GridLayout(3, 1));
		authorPanel.add(upAuthorPanel);
		authorPanel.add(midAuthorPanel);
		authorPanel.add(downAuthorPanel);
		
		
		
		//Add Items To Up Book Panel
		upBookPanel.setLayout(new GridLayout(4, 2));
		
		upBookPanel.add(bookTitle);
		upBookPanel.add(bookTitleField);
		upBookPanel.add(bookPrice);
		upBookPanel.add(bookPriceField);
		upBookPanel.add(bookPages);
		upBookPanel.add(bookPagesField);
		upBookPanel.add(bookPublishedOn);
		upBookPanel.add(bookPublishedOnField);
		
		//Add Items To Middle Book Panel
		
		midBookPanel.setLayout(new FlowLayout());
		midBookPanel.add(createBookBtn);
		midBookPanel.add(deleteBookBtn);
		midBookPanel.add(updateBookBtn);
		
		//Add Items To Down Book Panel
		
		booksScroll.setPreferredSize(new Dimension(565, 170));
		downBookPanel.add(booksScroll);
		
		
		//Add Items To Book Panel
		bookPanel.setLayout(new GridLayout(3, 1));
		bookPanel.add(upBookPanel);
		bookPanel.add(midBookPanel);
		bookPanel.add(downBookPanel);
		
		
		//Add items to up add book to author panel
		//upBookToAuthorPanel.setLayout(new GridLayout(1, 2));
		

		upBookToAuthorPanel.add(authorsLabel);
		upBookToAuthorPanel.add(authorsCombo);
		
		//Add items to mid add book to author panel
		midBookToAuthorPanel.add(booksLabel);
		midBookToAuthorPanel.add(booksCombo);
		
		//Add items to down add book to author panel
		downBookToAuthorPanel.add(addBookToAuthorBtn);
		downBookToAuthorPanel.add(removeBookFromAuthorBtn);
		
		
		//Add items to table add book to author panel
		bookToAuthorScroll.setPreferredSize(new Dimension(565, 120));
		tableBookToAuthorPanel.add(bookToAuthorScroll);
		
		//Add Items to add book to author panel
		authorBookPanel.setLayout(new GridLayout(4, 1));
		authorBookPanel.add(upBookToAuthorPanel);
		authorBookPanel.add(midBookToAuthorPanel);
		authorBookPanel.add(downBookToAuthorPanel);
		authorBookPanel.add(tableBookToAuthorPanel);
		
		//Add Items To Up Search Panel
		
		//upSearchBooksByTitlePanel.setLayout(new GridLayout(1, 2));
		input.setPreferredSize(new Dimension(400, 28));
		upSearchBooksByTitlePanel.add(input);
		upSearchBooksByTitlePanel.add(search);
		upSearchBooksByTitlePanel.add(refresh);
		
		//Add Items To Down Search Panel
		
		//searchResultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//searchResultTable.setPreferredSize(new Dimension(800, 250));
		//searchResultTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		searchResultScroll.setPreferredSize(new Dimension(565, 250));
		
		downSearchBooksByTitlePanel.add(searchResultScroll);
		
		//Add Items to search panel
		searchBooksByTitlePanel.setLayout(new GridLayout(2, 1));
		searchBooksByTitlePanel.add(upSearchBooksByTitlePanel);
		searchBooksByTitlePanel.add(downSearchBooksByTitlePanel);
		
		
		this.add(tab);
		
		//Add author button actions
		
		createAuthorBtn.addActionListener(new AddAuthor());
		deleteAuthorBtn.addActionListener(new DeleteAuthor());
		updateAuthorBtn.addActionListener(new UpdateAuthor());
		authorTable.addMouseListener(new AuthorMouseAction());
		
		//Add book button actions
		createBookBtn.addActionListener(new AddBook());
		deleteBookBtn.addActionListener(new DeleteBook());
		updateBookBtn.addActionListener(new UpdateBook());
		booksTable.addMouseListener(new BookMouseAction());
		
		
		//Add book to author button actions
		addBookToAuthorBtn.addActionListener(new AddBookToAuthor());
		removeBookFromAuthorBtn.addActionListener(new RemoveBookFromAuthor());
		bookToAuthorTable.addMouseListener(new BookAuthorMouseAction());
		
		
		//search
		search.addActionListener(new Search());
		refresh.addActionListener(new RefreshSearchTable());
		
		
		refreshTable(authorTable, "Authors");
		refreshTable(booksTable, "Books");
		refreshMappingTable();
		refreshSearchTable();
		
		fuillAuthorsComboBox();
		fuillBooksComboBox(); 
		
		
		this.setVisible(true);
	}
	
	public void refreshSearchTable() 
	{
		connection = DBContext.getConnection();
		
		String sql = "SELECT B.Name AS 'Book Title', STRING_AGG(LEFT(FirstName, 1) + '. ' + A.LastName, '; ') AS 'Author' FROM Books AS B JOIN AuthorsBooks AS AB ON B.Id = AB.BookId JOIN Authors AS A ON A.Id = AB.AuthorId GROUP BY B.Name";
		
		
		try 
		{
			statement = connection.prepareStatement(sql);
			
			
			result = statement.executeQuery();
			searchResultTable.setModel(new MyModel(result));
			
			
		} 
		catch (SQLException e1) 
		{
			
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	public void fuillAuthorsComboBox() 
	{
		authorsCombo.removeAllItems();
		connection = DBContext.getConnection();
		String sql = "SELECT Id, FirstName, LastName FROM Authors ORDER BY Id";
		String item = "";
		
		
		try 
		{
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next())
			{
				item = result.getObject(1).toString() + "." + " " + result.getObject(2).toString() + " " + result.getObject(3).toString();
				authorsCombo.addItem(item);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void fuillBooksComboBox() 
	{
		booksCombo.removeAllItems();
		connection = DBContext.getConnection();
		String sql = "SELECT Id, Name FROM Books ORDER BY Id";
		String item = "";
		
		
		try 
		{
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next())
			{
				item = result.getObject(1).toString() + "." + " " + result.getObject(2).toString();
				booksCombo.addItem(item);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshMappingTable() 
	{
		connection = DBContext.getConnection();
		
		try
		{
			statement = connection.prepareStatement("SELECT CONVERT(NVARCHAR, A.Id) + '. ' + A.FirstName + ' ' + A.LastName AS 'Author', CONVERT(NVARCHAR, B.Id) + '. ' + B.Name AS 'Book Title' FROM Authors AS A JOIN AuthorsBooks AS AB ON A.Id = AB.AuthorId JOIN Books AS B ON AB.BookId = B.Id ORDER BY A.Id");
			result = statement.executeQuery();
			bookToAuthorTable.setModel(new MyModel(result));
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshTable(JTable table, String tableName) 
	{
		connection = DBContext.getConnection();
		
		try 
		{
			statement = connection.prepareStatement("SELECT * FROM " + tableName);
			result =  statement.executeQuery();
			table.setModel(new MyModel(result));
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearBookForm() 
	{
		bookTitleField.setText("");
		bookPriceField.setText("");
		bookPagesField.setText("");
		bookPublishedOnField.setText("");
	}
	
	public void clearAuthorForm() 
	{
		authorFirstNameField.setText("");
		authorLastNameField.setText("");
		authorEmailField.setText("");
		authorPhoneField.setText("");
	}
	
	//Refresh book search class
	class RefreshSearchTable implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshSearchTable();
			
		}
		
	}
	
	//Search book class
	class Search implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			connection = DBContext.getConnection();
			
			String sql = "SELECT B.Name AS 'Book Title', STRING_AGG(LEFT(FirstName, 1) + '. ' + A.LastName, '; ') AS 'Author' FROM Books AS B JOIN AuthorsBooks AS AB ON B.Id = AB.BookId JOIN Authors AS A ON A.Id = AB.AuthorId WHERE B.Name LIKE ? GROUP BY B.Name";
			
			
			try 
			{
				statement = connection.prepareStatement(sql);
				statement.setString(1, input.getText() + "%");
				
				result = statement.executeQuery();
				searchResultTable.setModel(new MyModel(result));
				
				
			} 
			catch (SQLException e1) 
			{
				
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	//Add Book Class
	class AddBook implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			connection = DBContext.getConnection();
			String  sql = "INSERT INTO Books (Name, Price, Pages, PublishedOn) VALUES (?, ?, ?, ?)";
			try 
			{
				statement = connection.prepareStatement(sql);
				statement.setString(1, bookTitleField.getText());
				statement.setFloat(2, Float.parseFloat(bookPriceField.getText()));
				statement.setInt(3, Integer.parseInt(bookPagesField.getText()));
							
				statement.setString(4, bookPublishedOnField.getText());
				statement.execute();
				clearBookForm();
				refreshTable(booksTable, "Books");
				fuillAuthorsComboBox();
				fuillBooksComboBox(); 
			} 
			catch (SQLException e1) 
			{
				
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
	//Add book to author class
	class AddBookToAuthor implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			connection = DBContext.getConnection();
			
			String[] authorInfo = authorsCombo.getSelectedItem().toString().split(". ");
			String[] bookInfo = booksCombo.getSelectedItem().toString().split(". ");
			
			int authorId = Integer.parseInt(authorInfo[0]);
			int bookId = Integer.parseInt(bookInfo[0]);
			
			
			String sql = "INSERT INTO AuthorsBooks(AuthorId, BookId) VALUES (?, ?)";
			

			
			try
			{
				statement = connection.prepareStatement(sql);
				statement.setInt(1, authorId);
				statement.setInt(2, bookId);
				statement.execute();
				refreshMappingTable();
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
	}
	
	//Remove book from author class
	class RemoveBookFromAuthor implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			connection = DBContext.getConnection();
			
			String[] authorInfo = authorsCombo.getSelectedItem().toString().split(". ");
			String[] bookInfo = booksCombo.getSelectedItem().toString().split(". ");
			
			int authorId = Integer.parseInt(authorInfo[0]);
			int bookId = Integer.parseInt(bookInfo[0]);
			
			String sql = "DELETE FROM AuthorsBooks WHERE AuthorId = ? AND BookId = ?";
			
			try
			{
				statement = connection.prepareStatement(sql);
				statement.setInt(1, authorId);
				statement.setInt(2, bookId);
				statement.execute();
				refreshMappingTable();
			}
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
	
	//Add Author Class
	class AddAuthor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			connection = DBContext.getConnection();
			String  sql = "INSERT INTO Authors (FirstName, LastName, Email, Phone) VALUES (?, ?, ?, ?)";
			try 
			{
				statement = connection.prepareStatement(sql);
				statement.setString(1, authorFirstNameField.getText());
				statement.setString(2, authorLastNameField.getText());
				statement.setString(3, authorEmailField.getText());
				statement.setString(4, authorPhoneField.getText());
				statement.execute();
				clearAuthorForm();
				refreshTable(authorTable, "Authors");
				fuillAuthorsComboBox();
				fuillBooksComboBox(); 
			} 
			catch (SQLException e1) 
			{
				
				e1.printStackTrace();
			}
		}
				
	}
	
	//Delete book class
	class DeleteBook implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			connection = DBContext.getConnection();
			String  sql = "DELETE FROM AuthorsBooks WHERE BookId = ? DELETE FROM Books WHERE Id = ?";
			
			try 
			{
				statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.setInt(2, id);
				statement.execute();
				refreshTable(booksTable, "Books");
				refreshMappingTable();
				fuillAuthorsComboBox();
				fuillBooksComboBox(); 
				clearBookForm();
				id = -1;
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
	}
	
	//Delete author class
	class DeleteAuthor implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			connection = DBContext.getConnection();
			String  sql = "DELETE FROM AuthorsBooks WHERE AuthorId = ? DELETE FROM Authors WHERE Id = ?";
			
			try 
			{
				statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.setInt(2, id);
				statement.execute();
				refreshTable(authorTable, "Authors");
				refreshMappingTable();
				fuillAuthorsComboBox();
				fuillBooksComboBox(); 
				clearAuthorForm();
				id = -1;
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}

	}
	
	//Update book class
	class UpdateBook implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			connection = DBContext.getConnection();
			String  sql = "UPDATE Books SET Name = ?, Price = ?, Pages = ?, PublishedOn = ? WHERE Id = ?";
			
			try 
			{
				statement = connection.prepareStatement(sql);
				statement.setString(1, bookTitleField.getText());
				statement.setFloat(2, Float.parseFloat(bookPriceField.getText()));
				statement.setInt(3, Integer.parseInt(bookPagesField.getText()));
							
				statement.setString(4, bookPublishedOnField.getText());
				statement.setInt(5, id);
				statement.execute();
				refreshTable(booksTable, "Books");
				fuillAuthorsComboBox();
				fuillBooksComboBox(); 
				clearBookForm();
				id = -1;
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	//Update author class
	class UpdateAuthor implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			connection = DBContext.getConnection();
			String  sql = "UPDATE Authors SET FirstName = ?, LastName = ?, Email = ?, Phone = ? WHERE Id = ?";
			
			try 
			{
				statement = connection.prepareStatement(sql);
				statement.setString(1, authorFirstNameField.getText());
				statement.setString(2, authorLastNameField.getText());
				statement.setString(3, authorEmailField.getText());
				statement.setString(4, authorPhoneField.getText());
				statement.setInt(5, id);
				statement.execute();
				refreshTable(authorTable, "Authors");
				fuillAuthorsComboBox();
				fuillBooksComboBox(); 
				clearAuthorForm();
				id = -1;
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}

	}
	
	//BookAuthor mouse action class
	class BookAuthorMouseAction implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			int row = bookToAuthorTable.getSelectedRow();
			
			//id = Integer.parseInt(authorTable.getValueAt(row, 0).toString());
			
			if(e.getClickCount() > 1)
			{
				authorsCombo.setSelectedItem(bookToAuthorTable.getValueAt(row, 0));
				booksCombo.setSelectedItem(bookToAuthorTable.getValueAt(row, 1));
				
				//System.out.println(bookToAuthorTable.getValueAt(row, 0));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}	
	}
	
	
	//Book mouse action class
	class BookMouseAction implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			int row = booksTable.getSelectedRow();
			
			//id = Integer.parseInt(authorTable.getValueAt(row, 0).toString());
			
			if(e.getClickCount() > 1)
			{
				id = Integer.parseInt(booksTable.getValueAt(row, 0).toString());
				bookTitleField.setText(booksTable.getValueAt(row, 1).toString());
				//bookGenreField.setText(booksTable.getValueAt(row, 2).toString());
				bookPriceField.setText(booksTable.getValueAt(row, 2).toString());
				bookPagesField.setText(booksTable.getValueAt(row, 3).toString());
				
				//Remove time from publishedOn
				//String pattern = "yyyy-MM-dd";
				//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				//String date = simpleDateFormat.format(booksTable.getValueAt(row, 4));
				
				bookPublishedOnField.setText(booksTable.getValueAt(row, 4).toString());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}	
	}
	
	//Author mouse action class
	class AuthorMouseAction implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
			int row = authorTable.getSelectedRow();
			
			//id = Integer.parseInt(authorTable.getValueAt(row, 0).toString());
			
			if(e.getClickCount() > 1)
			{
				id = Integer.parseInt(authorTable.getValueAt(row, 0).toString());
				authorFirstNameField.setText(authorTable.getValueAt(row, 1).toString());
				authorLastNameField.setText(authorTable.getValueAt(row, 2).toString());
				authorEmailField.setText(authorTable.getValueAt(row, 3).toString());
				authorPhoneField.setText(authorTable.getValueAt(row, 4).toString());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}	
	}
}
