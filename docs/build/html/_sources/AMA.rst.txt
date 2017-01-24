AMA Class
=========

The AMA class offers a variety of static methods and functions which can be of assistance in creating your accessible Android application. During the development process, most of your interaction with AMA will be through this class. *Unless otherwise specified, all methods in this class are static*.

*Located in* ``edu.mit.dig.ama.core.AMA``

Vision
------

The following methods are particularly useful for handling cases where a user may have *impaired vision*. However, they may also be used in other settings as seen fit.

.. raw:: html

    <dl class="function"><dt><code class="descname">
    
      <em>boolean</em> isTalkBackInstalled
      
    </code><span class="sig-paren">(</span>
    
      Context <em>context</em>
      
    <span class="sig-paren">)</span><a class="reference internal" 
    
      href="_modules/artiq/language/core.html#mu_to_seconds">
      
    <span class="viewcode-link">[source]</span></a><a class="headerlink" 
    
      href="#ama.istalkbackinstalled"
      
    title="Permalink to this definition">¶</a></dt>
    <dd><p>
    
      Checks to see if TalkBack is installed (note that this is the Google version of TalkBack)
      
    </p>
    <table class="docutils field-list" frame="void" rules="none">
    <colgroup><col class="field-name">
    <col class="field-body">
    </colgroup><tbody valign="top">
    <tr class="field-odd field"><th class="field-name">Parameters:</th><td class="field-body"><ul class="first last simple">

      <li><strong>context</strong> – The calling activity</li>
      
    </ul>
    </td>
    </tr>
    </tbody>
    </table>
    <strong>Returns - </strong>
      
      true if Talkback is installed on this device
      
    </dd></dl>
    
.. raw:: html

    <dl class="function"><dt><code class="descname">
    
      <em>boolean</em> isTalkBackEnabled
      
    </code><span class="sig-paren">(</span>
    
      Context <em>context</em>
      
    <span class="sig-paren">)</span><a class="reference internal" 
    
      href="_modules/artiq/language/core.html#mu_to_seconds">
      
    <span class="viewcode-link">[source]</span></a><a class="headerlink" 
    
      href="#ama.istalkbackenabled"
      
    title="Permalink to this definition">¶</a></dt>
    <dd><p>
    
      Checks to see if TalkBack is currently enabled and running
      
    </p>
    <table class="docutils field-list" frame="void" rules="none">
    <colgroup><col class="field-name">
    <col class="field-body">
    </colgroup><tbody valign="top">
    <tr class="field-odd field"><th class="field-name">Parameters:</th><td class="field-body"><ul class="first last simple">

      <li><strong>context</strong> – The calling activity</li>
      
    </ul>
    </td>
    </tr>
    </tbody>
    </table>
    <strong>Returns - </strong>
      
      true if Talkback is enabled
      
    </dd></dl>
    
.. raw:: html

    <dl class="function"><dt><code class="descname">
    
      <em>boolean</em> isExploreByTouchEnabled
      
    </code><span class="sig-paren">(</span>
    
      Context <em>context</em>
      
    <span class="sig-paren">)</span><a class="reference internal" 
    
      href="_modules/artiq/language/core.html#mu_to_seconds">
      
    <span class="viewcode-link">[source]</span></a><a class="headerlink" 
    
      href="#ama.isexplorebytouchenabled"
      
    title="Permalink to this definition">¶</a></dt>
    <dd><p>
    
      Checks to see if explore by touch (provided via TalkBack) is currently enabled
      
    </p>
    <table class="docutils field-list" frame="void" rules="none">
    <colgroup><col class="field-name">
    <col class="field-body">
    </colgroup><tbody valign="top">
    <tr class="field-odd field"><th class="field-name">Parameters:</th><td class="field-body"><ul class="first last simple">

      <li><strong>context</strong> – The calling activity</li>
      
    </ul>
    </td>
    </tr>
    </tbody>
    </table>
    <strong>Returns - </strong>
      
      true if explore by touch is enabled
      
    </dd></dl>