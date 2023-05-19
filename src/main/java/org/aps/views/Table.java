package org.aps.views;

import javax.swing.JTable;
import org.aps.views.AddDataTable;

public class Table {

    private int rowHeight;
    private boolean enabled;
    private boolean dragEnabled;

    public Table() {
    }

    public Table
        (
             int rowHeight,
            boolean enabled,
            boolean dragEnabled
        ) 
        {
            this.rowHeight = rowHeight;
            this.enabled = enabled;
            this.dragEnabled = dragEnabled;
        }

    public int getRowHeight() {
        return this.rowHeight;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public boolean getDragEnabled() {
        return this.dragEnabled;
    }

    public void setRowHeight(int rowHeight) {
        this.rowHeight = rowHeight;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setDragEnabled(boolean dragEnabled) {
        this.dragEnabled = dragEnabled;
    }

    public JTable create() {
        String[] columnNames = { "Fauna/Flora", "Grupo", "Familia", "Especie(Simplificado)", "Nome Comum",
                "Categoria de Ameaça", "Bioma", "Principais Ameaças", "Estados de Ocorrência" };

        Object[][] data = {
                { "Flora", "angiospermas", "salicacae", "abatia angeliana", "-", "Vulneravel(VU)", "Mata Atlantica",
                        "perda de habitat/ degradacao(induzida por humanos)", "pr"
                },
                { "Flora", "angiospermas", "salicacae", "abatia angeliana", "-", "Vulneravel(VU)", "Mata Atlantica",
                        "perda de habitat/ degradacao(induzida por humanos)", "pr"
                },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null }

        };


        JTable table = new JTable();
        table.setEnabled(enabled);
        table.setDragEnabled(dragEnabled);
        table.setRowHeight(rowHeight);

        return table;
    }
}
