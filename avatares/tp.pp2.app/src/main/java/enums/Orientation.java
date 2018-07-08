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

		@Override
		public Orientation getReverse() {
			return LEFT;
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

		@Override
		public Orientation getReverse() {
			return RIGHT;
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

		@Override
		public Orientation getReverse() {
			return DOWN;
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

		@Override
		public Orientation getReverse() {
			return UP;
		}
	};
	
	public abstract Orientation getLeft();
	public abstract Orientation getRight();
	public abstract Orientation getReverse();
}