package basic.树;

/**
 * 红黑树:
 * 添加数据
 * 删除数据
 * 遍历查询数据
 * 要么为空，要么肯定有一个Root节点
 */
public class RBTTree<K extends Comparable<K>, V> {

    // 定义红黑常量
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    // 当前红黑树的root节点
    private RBNode root;


    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }

    /**
     * 新增节点的操作
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        // 1. 向一个普通的二叉查找树中插入节点
        // 记录当前节点
        RBNode t = this.root;
        if (t == null) {
            // 说明整个红黑树是空的，那么插入的节点就是Root节点，root节点的parent为空
            this.root = new RBNode(key, value == null ? key : value, null);
            this.root.color = BLACK;
            return;
        }
        if (key == null) {
            // key 是不允许为空的
            throw new NullPointerException();
        }
        // 声明需要插入的节点的父节点
        RBNode parent;
        int i;  // 记录插入的位置 i < 0 left ; i > 0 right
        // 有root节点吗，而且添加一个节点，那么我们肯定先要比较一次大小
        do {
            parent = t;
            // 输入的节点和当前比较的节点比较大小
            i = key.compareTo((K) t.key);
            if (i < 0) {
                t = t.left;
            } else if (i > 0) {
                t = t.right;
            } else {
                // 插入的节点的值和比较的节点的值相同
                // 覆盖掉原来的值
                t.setValue(value == null ? key : value);

                return;
            }
        } while (t != null);
        // 循环执行结束，表示我们找到了需要插入节点的位置
        // 创建需要插入的节点
        RBNode<K, Object> e = new RBNode<>(key, value, parent);
        if (i < 0) {
            parent.left = e;
        } else {
            parent.right = e;
        }

        // 2. 调整平衡，旋转和变色来实现的
        fixAfterPut(e);
    }

    /**
     * 红黑树节点的删除操作
     * 1. 节点的删除【普通的二叉查找树的节点删除】
     * 2. 通过旋转和变色来实现平衡
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        // 1. 我们需要根据你的key找到对应的RBNode，这个key在红黑树中的节点
        RBNode p = this.getNode(key);
        if (p == null) {
            return null;
        }
        V oldValue = (V) p.getValue();
        deleteNode(p);
        return oldValue;
    }

    /**
     * 具体删除节点操作的方法
     * 1. 删除二叉树中的一个节点
     * 1. 删除的是直接子节点，直接删除
     * 2. 删除的节点有一个子节点，那么就用子节点替代删除节点
     * 3. 删除的节点有两个字节蒂娜，那么我们就需要找到对应的前驱或者后继节点来替代
     * 2. 删除节点后需要调整
     *
     * @param node
     */
    private void deleteNode(RBNode node) {
        // 1. 删除的节点有两个子节点
        if (leftOf(node) != null && rightOf(node) != null) {
            // 我们就需要找到删除节点的前驱节点或者后继节点
            RBNode predecessor = predecessor(node);
            node.key = predecessor.key;
            node.value = predecessor.value;
            // 我们需要删除的节点 就是从原来的node 变为了 predecessor
            node = predecessor;
        }
        // 找到需要删除的节点
        RBNode replacement = leftOf(node) != null ? leftOf(node) : rightOf(node);
        if (replacement != null) {
            // 2. 删除的节点有一个子节点
            // 替代者的节点需要指向原来节点的父节点
            replacement.parent = node.parent;
            if (parentOf(node) == null) {
                // 说明node节点是root节点
                root = replacement;
            } else if (parentOf(node).left == node) {
                parentOf(node).left = replacement;
            } else {
                parentOf(node).right = replacement;
            }
            // 需要删除的节点去掉相关的关联关系，等待GC
            node.left = node.right = node.parent = null;

            // 考虑是否需要调整平衡
            if (colorOf(node) == BLACK) {
                // 需要做平衡的调整
                fixAfterRemove(replacement);
            }
        } else if (node.parent == null) {
            // 那就说明我们要删除的是 Root 节点
            root = null;
        } else {
            // 3. 删除的节点本身就是子节点
            if (colorOf(node) == BLACK) {
                // 需要做平衡的调整
                fixAfterRemove(node);
            }

            if (parentOf(node).left == node) {
                parentOf(node).left = null;
            } else {
                parentOf(node).right = null;
            }
            node.parent = null;
            node = null;
        }



        /*if (replacement != null) {
            // 2. 删除的节点有一个子节点
            node.key = replacement.key;
            node.value = replacement.value;
            node = replacement;
        }
        // 3. 删除的节点本身就是子节点
        RBNode p = parentOf(node);
        if (leftOf(p) == node) {
            p.left = null;
        } else {
            p.right = null;
        }
        node.parent = null;*/
    }

    /**
     * 删除节点后我们需要做的平衡处理
     * 1. 情况1：自己能够搞定
     * 2. 情况2：自己搞不定，找兄弟节点借。 兄弟节点借，父节点下移。 兄弟节点上移为新的父节点 变色+旋转操作
     * 3. 情况3：自己搞不定。找兄弟节点借。 兄弟节点不借 兄弟节点变红，递归处理
     *
     * @param x
     */
    private void fixAfterRemove(RBNode x) {
        // 处理情况2、3  删除节点是2节点
        while (x != root && colorOf(x) == BLACK) {
            // 删除节点是父亲节点的左侧子节点
            if (x == leftOf(parentOf(x))) {
                // 获取到当前节点的兄弟节点
                RBNode rbNode = rightOf(parentOf(x));
                // 找到的这个兄弟节点是真正的兄弟节点吗？
                if (colorOf(rbNode) == RED) {    // 这个节点不是真正的兄弟节点
                    setColor(rbNode, BLACK);
                    setColor(parentOf(x), RED);
                    leftRotate(parentOf(x));
                    // 找到真正的兄弟节点
                    rbNode = rightOf(parentOf(x));
                }
                // 情况3 找兄弟节点借，兄弟节点解不出来。兄弟节点没有任何的子节点
                if (colorOf(leftOf(rbNode)) == BLACK && colorOf(rightOf(rbNode)) == BLACK) {
                    // 变色
                    setColor(rbNode, RED);
                    x = parentOf(x);
                } else {
                    // 兄弟节点借    旋转 变色
                    if(colorOf(rightOf(rbNode)) == BLACK) {
                        // 兄弟节点的右侧子节点为空，那么左侧子节点肯定不为空
                        setColor(rbNode, RED);
                        setColor(leftOf(rbNode), BLACK);
                        rightRotate(rbNode);
                        // 兄弟节点有了变化
                        rbNode = rightOf(parentOf(x));
                    }
                    // 左旋+变色的操作
                    setColor(rbNode, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(rbNode), BLACK);
                    leftRotate(parentOf(x));
                    // 结束循环
                    x = root;
                }
            } else {
                // 删除节点是父亲节点的右侧子节点
                // 获取到当前节点的兄弟节点
                RBNode rbNode = leftOf(parentOf(x));
                // 找到的这个兄弟节点是真正的兄弟节点吗？
                if (colorOf(rbNode) == RED) {    // 这个节点不是真正的兄弟节点
                    setColor(rbNode, BLACK);
                    setColor(parentOf(x), RED);
                    rightRotate(parentOf(x));
                    // 找到真正的兄弟节点
                    rbNode = leftOf(parentOf(x));
                }
                // 情况3 找兄弟节点借，兄弟节点解不出来。兄弟节点没有任何的子节点
                if (colorOf(leftOf(rbNode)) == BLACK && colorOf(rightOf(rbNode)) == BLACK) {
                    // 变色
                    setColor(rbNode, RED);
                    x = parentOf(x);
                } else {
                    // 兄弟节点借    旋转 变色
                    if(colorOf(leftOf(rbNode)) == BLACK) {
                        // 兄弟节点的右侧子节点为空，那么左侧子节点肯定不为空
                        setColor(rbNode, RED);
                        setColor(leftOf(rbNode), BLACK);
                        leftRotate(rbNode);
                        // 兄弟节点有了变化
                        rbNode = leftOf(parentOf(x));
                    }
                    // 左旋+变色的操作
                    setColor(rbNode, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(rbNode), BLACK);
                    rightRotate(parentOf(x));
                    // 结束循环
                    x = root;
                }
            }
        }
        // 处理情况1 是3或者4节点
        setColor(x, BLACK);
    }

    /**
     * 查询当前节点的前驱节点
     *
     * @param node
     * @return
     */
    private RBNode predecessor(RBNode node) {
        if (node == null) {
            return null;
        } else if (leftOf(node) != null) {
            RBNode p = leftOf(node);
            while (p.right != null) {
                p = p.right;
            }
            return p;
        } else {
            // 当前节点没有左侧子节点的情况
            // 记录当前节点的父节点
            RBNode p = parentOf(node);
            // 记录动态父节点的子节点
            RBNode ch = node;
            while (p != null && ch == p.left) {
                ch = p;
                p = parentOf(p);
            }
            return p;
        }
    }

    /**
     * 查询当前节点的前驱节点
     *
     * @param node
     * @return
     */
    private RBNode successor(RBNode node) {
        if (node == null) {
            return null;
        } else if (rightOf(node) != null) {
            RBNode p = rightOf(node);
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            // 当前节点没有左侧子节点的情况
            // 记录当前节点的父节点
            RBNode p = parentOf(node);
            // 记录动态父节点的子节点
            RBNode ch = node;
            while (p != null && ch == p.right) {
                ch = p;
                p = parentOf(p);
            }
            return p;
        }
    }

    /**
     * 根据key找到对应的节点
     *
     * @param key
     * @return
     */
    private RBNode getNode(K key) {

        RBNode node = this.root;
        while (node != null) {
            int cmp = key.compareTo((K) node.getKey());
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                // 说明相等，找到了对应的节点
                return node;
            }
        }
        return null;
    }

    /**
     * 调整节点的平衡
     * 分析各种情况：
     * 1. 2-3-4树：是一个2节点 那么我们插入一个节点后，会变成3节点
     * 红黑树：就是给一个黑色节点添加了一个红色节点，那么这种情况我们是不需要处理的
     * <p>
     * <p>
     * 2. 2-3-4树：是一个3节点，插入一个节点后会变成4节点，会有3个元素
     * 在这种情况下会有6种情况，其中【根左左，根左右，根右右，根右左】是需要调整的，其中的【左根右有两种】我们是不需要处理的，
     * 红黑树：
     * 根左左和根右右我们需要通过一次左旋或者右旋，再加变色就可以了
     * 根左右和根右左需要通过两次旋转和变色才能处理
     * <p>
     * 3. 2-3-4树：是一个4节点的情况，添加一个节点后，会做裂变。中间的元素会升级为父节点。新增的元素会和其中一个子节点合并
     * 红黑树：我们只需要做变色处理就可以了
     *
     * @param e
     */
    private void fixAfterPut(RBNode<K, Object> e) {
        // 1. 插入的节点我们都设置为红色
        e.color = RED;

        // 2. 对红黑树做旋转和变色处理
        while (e != null && e != root && e.parent.color == RED) {
            // 找到所有的需要 调整处理【旋转或者变色】的情况
            if (parentOf(e) == parentOf(parentOf(e)).left) {
                // 当前节点的父节点是爷爷节点的左孩子节点
                RBNode y = leftOf(parentOf(parentOf(e)));
                if (colorOf(y) == RED) {
                    // 说明当前需要插入的节点的叔叔节点是存在的
                    // 变色处理，父亲节点和叔叔节点变为黑色，爷爷节点变为红色
                    setColor(parentOf(e), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(e)), RED);
                    // 需要做一个递归的处理
                    e = parentOf(parentOf(e));
                } else {
                    // 说明当前节点需要插入的节点的叔叔节点是不存在的
                    if (e == parentOf(e).right) {
                        // 说明我们需要做一次左旋的操作
                        e = parentOf(e);
                        leftRotate(e);
                    }
                    // 接下来根据爷爷节点做一次右旋操作
                    setColor(parentOf(e), BLACK);
                    setColor(parentOf(parentOf(e)), RED);
                    rightRotate(parentOf(parentOf(e)));
                }
            } else {
                // 当前节点的父节点是爷爷节点的右孩子节点
                RBNode y = rightOf(parentOf(parentOf(e)));
                if (colorOf(y) == RED) {
                    // 说明当前需要插入的节点的叔叔节点是存在的
                    // 变色处理，父亲节点和叔叔节点变为黑色，爷爷节点变为红色
                    setColor(parentOf(e), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(e)), RED);
                    // 需要做一个递归的处理
                    e = parentOf(parentOf(e));
                } else {
                    // 说明当前节点需要插入的节点的叔叔节点是不存在的
                    if (e == parentOf(e).left) {
                        // 说明我们需要做一次左旋的操作
                        e = parentOf(e);
                        rightRotate(e);
                    }
                    // 接下来根据爷爷节点做一次右旋操作
                    setColor(parentOf(e), BLACK);
                    setColor(parentOf(parentOf(e)), RED);
                    leftRotate(parentOf(parentOf(e)));
                }

            }
        }

        // 3. root节点都设置为黑色
        this.root.color = BLACK;
    }

    public boolean colorOf(RBNode node) {
        return node == null ? BLACK : node.color;
    }

    private RBNode parentOf(RBNode node) {
        return node != null ? node.parent : null;
    }

    private RBNode leftOf(RBNode node) {
        return node != null ? node.left : null;
    }

    private RBNode rightOf(RBNode node) {
        return node != null ? node.right : null;
    }

    private void setColor(RBNode node, boolean color) {
        if (node != null) {
            node.setColor(color);
        }
    }

    // 1. 旋转和变色     2. 添加数据【a.普通的二叉树插入  b.红黑树的平衡】   3. 删除数据     4. 遍历数据

    /**
     * 完成左旋的操作
     * 围绕p节点完成左旋的操作
     * p               pr[r]
     * /\                /\
     * pl pr[r]   -->   p  rr
     * /\           /\
     * rl rr        pl rl
     * 左旋的时候：
     * p-pl 和 pr[r]-rr 这两根线的关系是不变的
     * pr[r] - rl需要改变为p-rl
     *
     * @param p
     */
    public void leftRotate(RBNode p) {
        if (p == null) {
            return;
        }
        RBNode r = p.right;
        p.right = r.left;
        if (r != null && r.left != null) {
            // 表示如果r节点有左侧子节点，就需要挂载到旋转节点的右子节点
            r.left.parent = p;
        }
        if (r != null) {
            r.parent = p.parent;        // 不管p节点是否有父节点，我们都把父节点赋值给r的父节点
            if (p.parent == null) {
                // p是root节点，那么r会变为新的root节点
                this.root = r;
            } else if (p.parent.left == p) {
                // 说明p节点是其父节点的左侧子节点
                p.parent.left = r;
            } else {
                // 说明p节点是其父节点的右侧子节点
                p.parent.right = r;
            }
        }
        // 设置 p 和 r的关系
        r.left = p;
        p.parent = r;
    }

    /**
     * 完成右旋的操作
     * 围绕p节点完成左旋的操作
     * p               pr[r]
     * /\                /\
     * pl pr[r]   <--    p  rr
     * /\            /\
     * rl rr         pl rl
     * 左旋的时候：
     * p-pl 和 pr[r]-rr 这两根线的关系是不变的
     * pr[r] - rl需要改变为p-rl
     *
     * @param p
     */
    public void rightRotate(RBNode p) {
        if (p == null) {
            return;
        }
        RBNode r = p.left;
        p.left = r.right;
        if (r != null && r.right != null) {
            // 表示如果r节点有左侧子节点，就需要挂载到旋转节点的右子节点
            r.right.parent = p;
        }
        if (r != null) {
            r.parent = p.parent;        // 不管p节点是否有父节点，我们都把父节点赋值给r的父节点
            if (p.parent == null) {
                // p是root节点，那么r会变为新的root节点
                this.root = r;
            } else if (p.parent.right == p) {
                // 说明p节点是其父节点的左侧子节点
                p.parent.right = r;
            } else {
                // 说明p节点是其父节点的右侧子节点
                p.parent.left = r;
            }
        }
        // 设置 p 和 r的关系
        r.right = p;
        p.parent = r;
    }

    /**
     * 红黑树中的节点，
     * 自定义节点
     */
    static class RBNode<K extends Comparable<K>, V> {

        private RBNode parent;  // 当前节点的父节点
        private RBNode left;    // 当前节点的左侧子节点
        private RBNode right;   // 当前节点的右侧子节点

        // 当前节点的颜色
        private boolean color = BLACK;

        private K key;
        private V value;


        public RBNode() {
        }

        public RBNode(K key, V value, boolean color) {
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode(K key, V value, RBNode parent) {
            this.parent = parent;
            this.key = key;
            this.value = value;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
