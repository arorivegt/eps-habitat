package org.habitatguate.hgerp.seguridad.client.principal;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;

public class Panel extends Composite {

	private Grid grid;
	private Long id_empleado;
	
		public Panel() {
			//instanciar objetos
            grid = new Grid(2, 1);
            Menu menu = new Menu(this);
     		
     		//agregar menu
            grid.setWidget(0, 0, menu);
            grid.setSize("100%", "100%");
            menu.setSize("100%", "32px");
            initWidget(grid);
        }



		public Grid getGrid() {
			return grid;
		}

		public void setGrid(Grid grid) {
			this.grid = grid;
		}



		public Long getId_empleado() {
			return id_empleado;
		}


		public void setId_empleado(Long id_empleado) {
			this.id_empleado = id_empleado;
		}
}