"""Pembuat pasangan .java + .form (NetBeans GUI Builder) untuk JFrame/JPanel/JDialog dari spesifikasi pohon komponen."""
import os
from xml.sax.saxutils import quoteattr
LAY = 'org.netbeans.modules.form.compat2.layouts.'
SUP = LAY + 'support.'

class N:
    def __init__(s, cls, name, props=None, kids=None, layout=None, con=None, ev=None, items=None, cols=None, tab=None):
        s.cls, s.name, s.props, s.kids, s.layout, s.con, s.ev, s.items, s.cols, s.tab = cls, name, dict(props or {}), kids or [], layout, con, ev, items, cols, tab
        if 'con' in s.props: s.con = s.props.pop('con')
    @property
    def cont(s):
        return s.layout is not None or s.cls in ('javax.swing.JScrollPane', 'javax.swing.JTabbedPane') or bool(s.kids)
def IC(p): return ('icon', p)
def D(w, h): return ('dim', (w, h))
def E(t, l, b, r): return ('empty', (t, l, b, r))
def xp(k, v):
    if isinstance(v, bool): return f'<Property name="{k}" type="boolean" value="{str(v).lower()}"/>'
    if isinstance(v, int): return f'<Property name="{k}" type="int" value="{v}"/>'
    if isinstance(v, float): return f'<Property name="{k}" type="float" value="{v}"/>'
    if isinstance(v, str): return f'<Property name="{k}" type="java.lang.String" value={quoteattr(v)}/>'
    t, a = v
    if t == 'icon': return f'<Property name="{k}" type="javax.swing.Icon" editor="org.netbeans.modules.form.editors2.IconEditor"><Image iconType="3" name="{a}"/></Property>'
    if t == 'empty': return f'<Property name="{k}" type="javax.swing.border.Border" editor="org.netbeans.modules.form.editors2.BorderEditor"><Border info="org.netbeans.modules.form.compat2.border.EmptyBorderInfo"><EmptyBorder bottom="{a[2]}" left="{a[1]}" right="{a[3]}" top="{a[0]}"/></Border></Property>'
    if t == 'dim': return f'<Property name="{k}" type="java.awt.Dimension" editor="org.netbeans.beaninfo.editors.DimensionEditor"><Dimension value="[{a[0]}, {a[1]}]"/></Property>'
def jv(v):
    if isinstance(v, bool): return str(v).lower()
    if isinstance(v, int): return str(v)
    if isinstance(v, float): return f'{v}f'
    if isinstance(v, str): return '"' + v.replace('\\', '\\\\').replace('"', '\\"') + '"'
    t, a = v
    if t == 'icon': return f'new javax.swing.ImageIcon(getClass().getResource("{a}"))'
    if t == 'empty': return f'javax.swing.BorderFactory.createEmptyBorder({a[0]}, {a[1]}, {a[2]}, {a[3]})'
    if t == 'dim': return f'new java.awt.Dimension({a[0]}, {a[1]})'
def st(k): return 'set' + k[0].upper() + k[1:]
def lay_xml(l):
    if l is None: return ''
    k = l[0]
    if k == 'border': return f'<Layout class="{LAY}DesignBorderLayout"/>'
    if k == 'card': return f'<Layout class="{LAY}DesignCardLayout"/>'
    if k == 'box': return f'<Layout class="{LAY}DesignBoxLayout"><Property name="axis" type="int" value="{l[1]}"/></Layout>'
    if k == 'flow': return f'<Layout class="{LAY}DesignFlowLayout"><Property name="alignment" type="int" value="{l[1][0]}"/><Property name="hgap" type="int" value="{l[1][1]}"/><Property name="vgap" type="int" value="{l[1][2]}"/></Layout>'
    if k == 'grid':
        r, c, h, v = l[1]
        return f'<Layout class="{LAY}DesignGridLayout"><Property name="columns" type="int" value="{c}"/><Property name="rows" type="int" value="{r}"/><Property name="horizontalGap" type="int" value="{h}"/><Property name="verticalGap" type="int" value="{v}"/></Layout>'
def lay_java(l, t):
    k = l[0]
    if k == 'border': return f'{t}setLayout(new java.awt.BorderLayout());'
    if k == 'card': return f'{t}setLayout(new java.awt.CardLayout());'
    if k == 'box': return f'{t}setLayout(new javax.swing.BoxLayout({"getContentPane()" if t == "getContentPane()." else (t[:-1] if t else "this")}, javax.swing.BoxLayout.PAGE_AXIS));'
    if k == 'flow': return f'{t}setLayout(new java.awt.FlowLayout({l[1][0]}, {l[1][1]}, {l[1][2]}));'
    if k == 'grid':
        r, c, h, v = l[1]; return f'{t}setLayout(new java.awt.GridLayout({r}, {c}, {h}, {v}));'
def con_xml(parent, n):
    pc = parent.cls
    if pc == 'javax.swing.JTabbedPane' and n.tab:
        return f'<Constraints><Constraint layoutClass="{SUP}JTabbedPaneSupportLayout" value="{SUP}JTabbedPaneSupportLayout$JTabbedPaneConstraintsDescription"><JTabbedPaneConstraints tabName={quoteattr(n.tab)}><Property name="tabTitle" type="java.lang.String" value={quoteattr(n.tab)}/></JTabbedPaneConstraints></Constraint></Constraints>'
    if parent.layout and parent.layout[0] == 'border' and n.con:
        return f'<Constraints><Constraint layoutClass="{LAY}DesignBorderLayout" value="{LAY}DesignBorderLayout$BorderConstraintsDescription"><BorderConstraints direction="{n.con}"/></Constraint></Constraints>'
    return ''
def combo_xml(items):
    return f'<Property name="model" type="javax.swing.ComboBoxModel" editor="org.netbeans.modules.form.editors2.ComboBoxModelEditor"><StringArray count="{len(items)}">' + ''.join(f'<StringItem index="{i}" value={quoteattr(t)}/>' for i, t in enumerate(items)) + '</StringArray></Property>'
def table_xml(cols):
    return f'<Property name="model" type="javax.swing.table.TableModel" editor="org.netbeans.modules.form.editors2.TableModelEditor"><Table columnCount="{len(cols)}" rowCount="0">' + ''.join(f'<Column editable="false" index="{i}" title={quoteattr(c)} type="java.lang.Object"/>' for i, c in enumerate(cols)) + '</Table></Property>'
def node_xml(n, parent, ind):
    pad = '  ' * ind; o = []
    o.append(f'{pad}<{"Container" if n.cont else "Component"} class="{n.cls}" name="{n.name}">')
    if n.cls == 'javax.swing.JScrollPane' and n.kids and n.kids[0].cls == 'javax.swing.JTable':
        o.append(f'{pad}  <AuxValues><AuxValue name="autoScrollPane" type="java.lang.Boolean" value="true"/></AuxValues>')
    ps = ''.join(xp(k, v) for k, v in n.props.items())
    if n.items is not None: ps += combo_xml(n.items)
    if n.cols is not None: ps += table_xml(n.cols)
    if ps: o.append(f'{pad}  <Properties>{ps}</Properties>')
    if n.ev:
        o.append(f'{pad}  <Events>' + ''.join(f'<EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="{h}"/>' for h in n.ev) + '</Events>')
    cx = con_xml(parent, n)
    if cx: o.append(f'{pad}  {cx}')
    if n.cont:
        if n.cls == 'javax.swing.JScrollPane': o.append(f'{pad}  <Layout class="{SUP}JScrollPaneSupportLayout"/>')
        elif n.cls == 'javax.swing.JTabbedPane': o.append(f'{pad}  <Layout class="{SUP}JTabbedPaneSupportLayout"/>')
        elif n.layout: o.append(f'{pad}  {lay_xml(n.layout)}')
        if n.kids:
            o.append(f'{pad}  <SubComponents>')
            for k in n.kids: o.append(node_xml(k, n, ind + 2))
            o.append(f'{pad}  </SubComponents>')
    o.append(f'{pad}</{"Container" if n.cont else "Component"}>')
    return '\n'.join(o)
def walk(n):
    for k in n.kids:
        yield k; yield from walk(k)
def emit(n, out, root=False, kind='frame'):
    tgt = ('getContentPane().' if kind != 'panel' else '') if root else n.name + '.'
    for k in n.kids:
        out.append(f'        {k.name}.setName("{k.name}");')
        for pk, pv in k.props.items(): out.append(f'        {k.name}.{st(pk)}({jv(pv)});')
        if k.items is not None: out.append(f'        {k.name}.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{{{", ".join(jv(i) for i in k.items)}}}));')
        if k.cols is not None:
            c = ', '.join(jv(x) for x in k.cols)
            out.append(f'        {k.name}.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{}}, new String[]{{{c}}}) {{\n            public boolean isCellEditable(int row, int col) {{\n                return false;\n            }}\n        }});')
        for h in (k.ev or []):
            out.append(f'        {k.name}.addActionListener(new java.awt.event.ActionListener() {{\n            public void actionPerformed(java.awt.event.ActionEvent evt) {{\n                {h}(evt);\n            }}\n        }});')
    if n.layout and n.cls not in ('javax.swing.JScrollPane', 'javax.swing.JTabbedPane'): out.append('        ' + lay_java(n.layout, tgt))
    for k in n.kids:
        if k.cont: emit(k, out)
    for k in n.kids:
        if n.cls == 'javax.swing.JScrollPane': out.append(f'        {n.name}.setViewportView({k.name});')
        elif n.cls == 'javax.swing.JTabbedPane': out.append(f'        {n.name}.addTab({jv(k.tab)}, {k.name});')
        elif n.layout and n.layout[0] == 'border' and k.con: out.append(f'        {tgt}add({k.name}, java.awt.BorderLayout.{k.con.upper()});')
        else: out.append(f'        {tgt}add({k.name});')
INFO = {'frame': 'JFrameFormInfo', 'panel': 'JPanelFormInfo', 'dialog': 'JDialogFormInfo'}
BASE = {'frame': 'javax.swing.JFrame', 'panel': 'javax.swing.JPanel', 'dialog': 'javax.swing.JDialog'}
def collect_handlers(root):
    hs = {}
    for k in walk(root):
        if k.ev:
            for h in k.ev: hs[h] = k
    return hs
def dser(w, h):
    """Serialisasi java.awt.Dimension (format 'designerSize' NetBeans): ukuran kanvas tab Design."""
    import struct
    pre = [-84, -19, 0, 5, 115, 114, 0, 18, 106, 97, 118, 97, 46, 97, 119, 116, 46, 68, 105, 109, 101, 110, 115, 105, 111, 110, 65, -114, -39, -41, -84, 95, 68, 20, 2, 0, 2, 73, 0, 6, 104, 101, 105, 103, 104, 116, 73, 0, 5, 119, 105, 100, 116, 104, 120, 112]
    return ','.join(map(str, pre + list(struct.unpack('>8b', struct.pack('>ii', h, w)))))
def gen(kind, pkg, cls, title, size, kids, layout, post, base_dir, extra='', handlers=None, imports=''):
    root = N(BASE[kind], cls, kids=kids, layout=layout)
    handlers = handlers or {}
    form = ['<?xml version="1.0" encoding="UTF-8" ?>', '', f'<Form version="1.5" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.{INFO[kind]}">', '  <Properties>']
    if kind == 'frame':
        form += ['    <Property name="defaultCloseOperation" type="int" value="3"/>', f'    <Property name="title" type="java.lang.String" value={quoteattr(title)}/>']
    if kind == 'dialog':
        form += [f'    <Property name="title" type="java.lang.String" value={quoteattr(title)}/>', '    <Property name="modal" type="boolean" value="true"/>', '    <Property name="resizable" type="boolean" value="false"/>']
    form.append(f'    {xp("preferredSize", D(*size))}')
    form += ['  </Properties>']
    if kind != 'panel': form += ['  <SyntheticProperties>', '    <SyntheticProperty name="formSizePolicy" type="int" value="0"/>', f'    <SyntheticProperty name="designerSize" type="java.awt.Dimension" value="{dser(*size)}"/>', '  </SyntheticProperties>']
    form += ['  <AuxValues>']
    if kind == 'panel': form += [f'    <AuxValue name="designerSize" type="java.awt.Dimension" value="{dser(*size)}"/>']
    form += [f'    <AuxValue name="FormSettings_{a}" type="java.lang.{t}" value="{v}"/>' for a, t, v in [
        ('autoResourcing', 'Integer', '0'), ('autoSetComponentName', 'Boolean', 'true'), ('generateFQN', 'Boolean', 'true'), ('generateMnemonicsCode', 'Boolean', 'false'),
        ('i18nAutoMode', 'Boolean', 'false'), ('layoutCodeTarget', 'Integer', '1'), ('listenerGenerationStyle', 'Integer', '0'), ('variablesLocal', 'Boolean', 'false'), ('variablesModifier', 'Integer', '2')]]
    form += ['  </AuxValues>', '', '  ' + lay_xml(layout), '  <SubComponents>']
    for k in kids: form.append(node_xml(k, root, 2))
    form += ['  </SubComponents>', '</Form>', '']
    allk = list(walk(root)); out = ['    private void initComponents() {']
    for k in allk: out.append(f'        {k.name} = new {k.cls}();')
    out.append('')
    if kind == 'frame':
        out += ['        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);', f'        setTitle({jv(title)});']
    if kind == 'dialog':
        out += [f'        setTitle({jv(title)});', '        setModal(true);', '        setResizable(false);']
    out.append(f'        setPreferredSize({jv(D(*size))});')
    emit(root, out, True, kind)
    out += ['        pack();' if kind != 'panel' else '', '    }// </editor-fold>//GEN-END:initComponents']
    hs = collect_handlers(root); hj = []
    for h, k in hs.items():
        body = handlers.get(h, f'        Dialogs.todo(this, {jv(k.props.get("text", k.name))}); // TODO backend')
        hj.append(f'    private void {h}(java.awt.event.ActionEvent evt) {{//GEN-FIRST:event_{h}\n{body}\n    }}//GEN-LAST:event_{h}\n')
    decl = ['    // Variables declaration - do not modify//GEN-BEGIN:variables'] + [f'    private {k.cls} {k.name};' for k in allk] + ['    // End of variables declaration//GEN-END:variables']
    ctor = f'    public {cls}(java.awt.Frame parent, boolean modal) {{\n        super(parent, modal);' if kind == 'dialog' else f'    public {cls}() {{'
    src = (f'package {pkg};\n\nimport agrova.util.*;\n{imports}\n/** {title}. Tampilan dikelola NetBeans GUI Builder (tab Design); gaya diterapkan oleh Styler. */\n'
           f'public class {cls} extends {BASE[kind]} {{\n\n    static {{\n        Theme.install(); // aman dipanggil berulang; menjamin tema aktif walau form dijalankan sendiri\n    }}\n\n{ctor}\n        initComponents();\n{post}\n    }}\n\n' +
           (f'    public static void main(String[] args) {{\n        java.awt.EventQueue.invokeLater(() -> new {cls}().setVisible(true));\n    }}\n\n' if kind == 'frame' else '') + '    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents\n' + '\n'.join(out) + '\n\n' + '\n'.join(hj) + extra + '\n' + '\n'.join(decl) + '\n}\n')
    d = os.path.join(base_dir, pkg.replace('.', '/')); os.makedirs(d, exist_ok=True)
    open(os.path.join(d, cls + '.java'), 'w').write(src); open(os.path.join(d, cls + '.form'), 'w').write('\n'.join(form))
