package GUI;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class Colorir extends JLabel implements	TableCellRenderer{
    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, 
                                            int row, int column) {

        String category = table.getValueAt(row, 1).toString();
        if(category.equals("Supermercado")||
                category.equals("Aluguel")||
                category.equals("Luz")||
                category.equals("Água")||
                category.equals("Telefone")||
                category.equals("Internet")||
                category.equals("Celular")||
                category.equals("Outro")) {
            setForeground(Color.RED);	
        } else if(category.equals("Bolsa")||
                category.equals("Freelance")||
                category.equals("Salário")||
                category.equals("Outros")) {
            setForeground(Color.GREEN);		
        }//table.
        setText(value.toString());
        return this;   	
        } 

    }