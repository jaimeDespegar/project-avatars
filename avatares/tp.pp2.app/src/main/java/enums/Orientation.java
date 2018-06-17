package enums;

public enum Orientation {
	RIGHT {
		@Override
		public Orientation getLeft() {
			return UP;
		}

		@Override
		public Orientation getRight() {
			return DOWN;
		}
	}, 
	
	LEFT {
		@Override
		public Orientation getLeft() {
			return DOWN;
		}

		@Override
		public Orientation getRight() {
			return UP;
		}
	}, 
	
	UP {
		@Override
		public Orientation getLeft() {
			return LEFT;
		}

		@Override
		public Orientation getRight() {
			return RIGHT;
		}
	}, 
	
	DOWN {
		@Override
		public Orientation getLeft() {
			return RIGHT;
		}

		@Override
		public Orientation getRight() {
			return LEFT;
		}
	};
	
	public abstract Orientation getLeft();
	public abstract Orientation getRight();
}
