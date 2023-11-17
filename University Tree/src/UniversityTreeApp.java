import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode; 
import javax.swing.tree.DefaultTreeCellRenderer; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

public class UniversityTreeApp {
    private static JTree tree;
    // Създаване на факултети и катедри
    public static void main(String[] args) {
        JFrame frame = new JFrame("Университетска йерархия");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Тракийски Университет");
        
        addFacultyAndDepartments(root, "Аграрен Факултет",
                "Катедра Аграрно инженерство",
                "Катедра Биологически науки",
                "Катедра Екология и зоохигиена",
                "Катедра Животновъдство - преживни животни и технологии на животинските продукти",
                "Катедра Животновъдство – непреживни животни и специални отрасли",
                "Катедра Растениевъдство",
                "Катедра Фундаментални науки в животновъдството");

        addFacultyAndDepartments(root, "Стопански Факултет",
                "Катедра Икономика",
                "Катедра Индустриален бизнес и предприемачество",
                "Катедра Информатика и математика",
                "Катедра Мениджмънт",
                "Катедра Обществени науки и бизнес езиково обучение",
                "Катедра Регионално развитие",
                "Катедра Физическо възпитание и спорт");

        addFacultyAndDepartments(root, "Ветеринарно-медицински Факултет",
                "Катедра Акушерство, репродукция и репродуктивни нарушения",
                "Катедра Ветеринарна микробиология, инфекциозни и паразитни болести",
                "Катедра Ветеринарна хирургия",
                "Катедра Вътрешни болести",
                "Катедра Качество и безопасност на храните и ветеринарно законодателство",
                "Катедра Oбща и клинична патология",
                "Катедра Общо животновъдство",
                "Катедра Фармакология, физиология на животните и физиологична химия",
                "Катедра Ветеринарна анатомия, хистология и ембриология");

        addFacultyAndDepartments(root, "Педагогически Факултет",
                "Катедра Информационни технологии, изобразително изкуство, чужди езици",
                "Катедра Педагогически и социални науки",
                "Катедра Предучилищна и начална училищна педагогика");

        addFacultyAndDepartments(root, "Медицински факултет",
                "И-ва Катедра по Вътрешни болести и Обща медицина",
                "ІІ – ра Катедра терапия на Вътрешните болести",
                "Анатомия",
                "Катедра Акушерство и гинекология",
                "Катедра Детски болести",
                "Катедра Обща и клинична патология, съдебна медицина, деонтология и дерматовенерология",
                "Катедра Пропедевтика на вътрешни болести и клинична лаборатория",
                "Катедра Социална медицина и здравен мениджмънт",
                "Катедра Хигиена, епидемиология, микробиология, паразитология и инфекциозни болести",
                "Катедра „Здравни грижи“",
                "Медицинска психология социални дейности и чужди езици",
                "Медицинска рехабилитация и ерготерапия, физикална медицина и спорт",
                "Медицинска физика, биофизика, рентгенология и радиология",
                "Медицинска химия и Биохимия",
                "Молекулярна биология, имунология и медицинска генетика",
                "Неврология, психиатрия и МБС",
                "Обща и оперативна хирургия, неврохирургия и урология",
                "Оториноларингология и офталмология",
                "Специална хирургия, гръдна хирургия, съдова хирургия и ангиология, детска хирургия и ортопедия и травматология",
                "Физиология, патофизиология и фармакология",
                "Хирургически болести и анестезиология");

        addFacultyAndDepartments(root, "Факултет \"Техника и технологии\" – Ямбол",
                "Катедра \"Машинно инженерство\"",
                "Катедра “Енергетика”",
                "Катедра “Хранителни технологии”",
                "Катедра „Електротехника, електроника и автоматика”");

        tree = new JTree(root);
        tree.setBackground(Color.darkGray);
        
        setupUI(frame);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
    private static void addFacultyAndDepartments(DefaultMutableTreeNode root, String facultyName, String... departmentNames) {
        DefaultMutableTreeNode faculty = new DefaultMutableTreeNode(facultyName);
        root.add(faculty);

        for (String departmentName : departmentNames) {
            faculty.add(new DefaultMutableTreeNode(departmentName));
        }
    }

    private static void setupUI(JFrame frame) {
        // Меню
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");

        // Подменю
        JMenu fontSizeMenu = new JMenu("Font Size");

        // Размери
        JMenuItem fontSizeMenuItem1 = new JMenuItem("Tiny");
        JMenuItem fontSizeMenuItem2 = new JMenuItem("Small");
        JMenuItem fontSizeMenuItem3 = new JMenuItem("Medium");
        JMenuItem fontSizeMenuItem4 = new JMenuItem("Large");
        JMenuItem fontSizeMenuItem5 = new JMenuItem("Huge");

        fontSizeMenuItem1.addActionListener(new FontSizeChangeListener(16));
        fontSizeMenuItem2.addActionListener(new FontSizeChangeListener(28));
        fontSizeMenuItem3.addActionListener(new FontSizeChangeListener(20));
        fontSizeMenuItem4.addActionListener(new FontSizeChangeListener(26));
        fontSizeMenuItem5.addActionListener(new FontSizeChangeListener(32));

        fontSizeMenu.add(fontSizeMenuItem1);
        fontSizeMenu.add(fontSizeMenuItem2);
        fontSizeMenu.add(fontSizeMenuItem3);
        fontSizeMenu.add(fontSizeMenuItem4);
        fontSizeMenu.add(fontSizeMenuItem5);

        optionsMenu.add(fontSizeMenu);
        menuBar.add(optionsMenu);
        frame.setJMenuBar(menuBar);

        // Set up tree renderer
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
        renderer.setBackgroundSelectionColor(new Color(0, 0, 0, 0));
        renderer.setTextSelectionColor(Color.cyan);
        renderer.setTextNonSelectionColor(Color.lightGray);
        tree.setCellRenderer(renderer);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 0))); // Adjust the width as needed
        panel.add(new JScrollPane(tree));
        frame.add(panel);
    }

    private record FontSizeChangeListener(int fontSize) implements ActionListener {

        @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = tree.getFont();
                tree.setFont(new Font(currentFont.getName(), currentFont.getStyle(), fontSize));
            }
        }
}

