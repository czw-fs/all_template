package com.example.springsecuritybase.modules.System.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecuritybase.modules.System.menu.convert.MenuConvert;
import com.example.springsecuritybase.modules.System.menu.mapper.MenuMapper;
import com.example.springsecuritybase.modules.System.menu.model.dto.CreateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.MenuSearchDto;
import com.example.springsecuritybase.modules.System.menu.model.dto.UpdateMenuDto;
import com.example.springsecuritybase.modules.System.menu.model.eneities.Menu;
import com.example.springsecuritybase.modules.System.menu.model.enums.MenuDisplay;
import com.example.springsecuritybase.modules.System.menu.model.enums.MenuType;
import com.example.springsecuritybase.modules.System.menu.model.vo.MenuVo;
import com.example.springsecuritybase.modules.System.menu.model.vo.Meta;
import com.example.springsecuritybase.modules.System.menu.model.vo.RouteVO;
import com.example.springsecuritybase.modules.System.menu.service.MenuService;
import com.example.springsecuritybase.modules.common.model.enums.SystemConstants;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    private final MenuMapper menuMapper;
    private final MenuConvert menuConvert;

    @Override
    public List<RouteVO> getRoutes() {
        return setChildren(null,SystemConstants.MENU_ROOT_ID);
    }

    private List<RouteVO> setChildren(RouteVO parentRouteVO, Long parentId) {
        // 查询指定父 ID 的子菜单
        List<Menu> childMenus = menuMapper.selectList(
                new LambdaQueryWrapper<Menu>()
                        .eq(Menu::getParentId, parentId)
                        .in(Menu::getType, Arrays.asList(MenuType.MENU, MenuType.CATALOG))
        );

        // 初始化子 RouteVO 列表
        List<RouteVO> routeVOList = new ArrayList<>();
        for (Menu childMenu : childMenus) {

            RouteVO routeVO = setMeta(childMenu);
            List<RouteVO> children = setChildren(routeVO, childMenu.getId());

            routeVO.setChildren(children.isEmpty() ? null : children);
            routeVOList.add(routeVO);
        }

        return routeVOList;
    }

    private RouteVO setMeta(Menu menu) {
        RouteVO routeVO = new RouteVO()
                .setName(menu.getRouterName())
                .setPath(menu.getRoutePath())
                .setComponent(menu.getComponentPath())
                .setRedirect(menu.getRedirect())
                ;

        Meta meta = new Meta()
                .setTitle(menu.getName())
                .setIcon(menu.getIcon())
                .setHidden(menu.getDisplay().equals(MenuDisplay.HIDDEN))
                .setAlwaysShow(true)
                ;

        //解析成 Map
        if (menu.getParams() != null) {
            Map<String, String> paramsMap = null;
            try {
                paramsMap = new Gson().fromJson(menu.getParams(), new TypeToken<Map<String, String>>(){}.getType());
            } catch (JsonSyntaxException e) {
                throw new RuntimeException("params解析异常",e);
            }
            meta.setParams(paramsMap);
        }

        routeVO.setMeta(meta);
        return routeVO;
    }


    @Override
    public void create(CreateMenuDto menuDto) {
        Menu menu = menuConvert.createMenuDtoToEntity(menuDto);
        menuMapper.insert(menu);
    }

    @Override
    public void update(UpdateMenuDto menuDto) {
        Menu menu = menuConvert.updateMenuDtoToEntity(menuDto);
        menuMapper.updateById(menu);
    }

    @Override
    public MenuVo getOneById(Long id) {
        Menu menu = menuMapper.selectById(id);
        MenuVo menuDto = menuConvert.entityToMenuVo(menu);
        return menuDto;
    }

    @Override
    public List<MenuVo> getList(MenuSearchDto dto) {
        List<Menu> menuList = menuMapper.getList(dto);
        List<MenuVo> menuDtos = menuConvert.entityListToDtoList(menuList);
        return menuDtos;
    }
}
